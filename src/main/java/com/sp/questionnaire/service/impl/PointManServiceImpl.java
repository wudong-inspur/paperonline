package com.sp.questionnaire.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.questionnaire.dao.KinShipDao;
import com.sp.questionnaire.dao.PointManDao;
import com.sp.questionnaire.entity.Kinship;
import com.sp.questionnaire.entity.PointMan;
import com.sp.questionnaire.service.PointManService;
import com.sp.questionnaire.utils.CommonUtils;

@Service
public class PointManServiceImpl implements PointManService {

    @Autowired
    private PointManDao pmDao;

    @Autowired
    private KinShipDao kinShipDao;

    @Autowired
    private CommonUtils commonUtils;

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

        // 2.插入本村亲属关系
        for (Kinship kinship : pm.getInKinShips()) {
            kinship.setId(commonUtils.getUUID());
            kinship.setPointmanNo(pm.getPointManNo());
            kinship.setInCountry(true);
            kinShipDao.insertKinShip(kinship);
        }

        // 3.插入外村亲属关系

        for (Kinship kinship : pm.getOutKinShips()) {
            kinship.setId(commonUtils.getUUID());
            kinship.setPointmanNo(pm.getPointManNo());
            kinship.setInCountry(false);
            kinShipDao.insertKinShip(kinship);
        }
        return isSuccess;
    }

    @Override
    public PointMan queryPointManByNo(String pointmanNo) {
        return pmDao.queryPointManByNo(pointmanNo);
    }

    @Override
    public List<PointMan> queryPointmanPaging(int page, int pageSize, String field, String dir) {
        page = (page - 1) * pageSize;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("page", page);
        map.put("pageSize", pageSize);
        return pmDao.queryPointmanPaging(page, pageSize, field, dir);
    }

    public void downloadAllData(){
        File file = new File ("target/classes/template/template.xlsx");
        
    }
    
    public static void main(String[] args) {
        // File file = new File("test");
        // file.getAbsoluteFile().

        System.out.println(Class.class.getClass().getResource("/").getPath());
        File file = new File ("target/classes/template/template.xlsx");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isFile());
    }
}