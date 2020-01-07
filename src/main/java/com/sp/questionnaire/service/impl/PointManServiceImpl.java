package com.sp.questionnaire.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.questionnaire.dao.KinShipDao;
import com.sp.questionnaire.dao.PointManDao;
import com.sp.questionnaire.entity.Kinship;
import com.sp.questionnaire.entity.PointMan;
import com.sp.questionnaire.service.PointManService;
import com.sp.questionnaire.utils.CommonUtils;
import com.sp.questionnaire.utils.DataWriter;

@Service
public class PointManServiceImpl implements PointManService {

    @Autowired
    private PointManDao pmDao;

    @Autowired
    private KinShipDao kinShipDao;

    @Autowired
    private CommonUtils commonUtils;

    @Autowired
    private DataWriter dw;

    @Transactional
    @Override
    public boolean insertPointMan(PointMan pm) {
        boolean isSuccess = false;
        if (StringUtils.isEmpty(pm.getPointManNo())) {
            throw new RuntimeException("指示者编号为空");
        }

        PointMan pm0 = queryPointManByNo(pm.getPointManNo());
        if (pm0 != null) {
            throw new RuntimeException("指示者编号重复");
        }

        // 1.插入指示者信息
        try {
            pm.setId(commonUtils.getUUID());
            int i = pmDao.insertPointMan(pm);
            if (i == 1) {
                isSuccess = true;
            } else {
                throw new RuntimeException("a:插入指示者失败！" + pm);
            }
        } catch (Exception e) {
            throw new RuntimeException("b:插入指示者失败：" + e.getMessage());
        }

        Map<String, Integer> countMap = new HashMap<String, Integer>();
        // 2.插入本村亲属关系
        for (Kinship kinship : pm.getInKinShips()) {
            kinship.setId(commonUtils.getUUID());
            kinship.setPointmanNo(pm.getPointManNo());
            kinship.setInCountry(true);
//            Integer count = countMap.get(kinship.getKinshipCode());
//            if (count == null) {
//                countMap.put(kinship.getKinshipCode(), 1);
//                kinship.setKinshipInputCode(getKinshipInputCode(pm.getPointManNo(), kinship.getKinshipCode(),
//                        commonUtils.convertInt2String(1)));
//            } else {
//                kinship.setKinshipInputCode(getKinshipInputCode(pm.getPointManNo(), kinship.getKinshipCode(),
//                        commonUtils.convertInt2String(count)));
//            }
            kinShipDao.insertKinShip(kinship);
        }

        // 3.插入外村亲属关系
        for (Kinship kinship : pm.getOutKinShips()) {
            kinship.setId(commonUtils.getUUID());
            kinship.setPointmanNo(pm.getPointManNo());
            kinship.setInCountry(false);
//            Integer count = countMap.get(kinship.getKinshipCode());
//            if (count == null) {
//                countMap.put(kinship.getKinshipCode(), 1);
//                kinship.setKinshipInputCode(getKinshipInputCode(pm.getPointManNo(), kinship.getKinshipCode(),
//                        commonUtils.convertInt2String(1)));
//            } else {
//                kinship.setKinshipInputCode(getKinshipInputCode(pm.getPointManNo(), kinship.getKinshipCode(),
//                        commonUtils.convertInt2String(count)));
//            }
            kinShipDao.insertKinShip(kinship);
        }
        return isSuccess;
    }

    private String getKinshipInputCode(String pmNo, String kinshipCode, String count) {
        StringBuffer sb = new StringBuffer();
        sb.append(pmNo);
        sb.append(kinshipCode);
        sb.append(count);
        return sb.toString();
    }

    @Override
    public PointMan queryPointManByNo(String pointmanNo) {
        return pmDao.queryPointManByNo(pointmanNo);
    }

    @Override
    public Map<String, Object> queryPointmanPaging(int page, int pageSize, String field, String dir) {
        page = (page - 1) * pageSize;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("page", page);
        map.put("pageSize", pageSize);
        int total = pmDao.getPointmanCount();
        List<PointMan> pmList = pmDao.queryPointmanPaging(page, pageSize, field, dir);
        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("total", total);
        retMap.put("data", pmList);
        return retMap;
    }

    @Override
    public XSSFWorkbook downloadAllDatas() {
        List<PointMan> datas = this.pmDao.getAllPointman();
        try {
            return dw.writePointman2Excel(datas);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("写入Excel失败");
        }
    }

    @Override
    public boolean deletePointman(String pmid) {
        PointMan pm = this.pmDao.getPointmanById(pmid);
        if (pm == null) {
            throw new RuntimeException("指示者信息不存在");
        }
        kinShipDao.deleteKinship(pm.getPointManNo());
        int count = pmDao.deletePointman(pmid);
        return count == 1;
    }

	@Override
	public PointMan queryPointManById(String id) {
		PointMan pm = this.pmDao.getPointmanById(id);
		List<Kinship> kinShips = this.kinShipDao.getKinshipByPointmanNo(pm.getPointManNo());
		List<Kinship> inKinShips = new ArrayList<Kinship>(); 
		List<Kinship> outKinShips = new ArrayList<Kinship>();
		for (Kinship ks : kinShips){
			if (ks.isInCountry()){
				inKinShips.add(ks);
			}else{
				outKinShips.add(ks);
			}
		}
		pm.setInKinShips(inKinShips);
		pm.setOutKinShips(outKinShips);
		return pm;
	}
}
