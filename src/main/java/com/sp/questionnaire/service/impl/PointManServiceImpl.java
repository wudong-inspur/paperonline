package com.sp.questionnaire.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.questionnaire.dao.KinShipDao;
import com.sp.questionnaire.dao.PointManDao;
import com.sp.questionnaire.entity.Kinship;
import com.sp.questionnaire.entity.PointMan;
import com.sp.questionnaire.service.PointManService;

@Service
public class PointManServiceImpl implements PointManService {

	@Autowired
	private PointManDao pmDao;

	@Autowired
	private KinShipDao kinShipDao;
	
	@Transactional
	@Override
	public boolean insertPointMan(PointMan pm) {
		boolean isSuccess = false;
		if (StringUtils.isEmpty(pm.getId())	|| StringUtils.isEmpty(pm.getPointManNo())) {
			throw new RuntimeException("指示者ID或编号为空");
		}

		PointMan pm0 = queryPointManByNo(pm.getPointManNo());
		if (pm0 != null) {
			throw new RuntimeException("指示者编号重复");
		}
		
		//1.插入指示者信息
		try {
			int i = pmDao.insertPointMan(pm);
			if (i == 1) {
				isSuccess = true;
			} else {
				throw new RuntimeException("a:插入指示者失败！" + pm);
			}
		} catch (Exception e) {
			throw new RuntimeException("b:插入指示者失败：" + e.getMessage());
		}
		
		//2.插入本村亲属关系
		for (Kinship kinship : pm.getInKinShips()){
			kinship.setPointmanNo(pm.getPointManNo());
			kinship.setInCountry(true);
			kinShipDao.insertKinShip(kinship);
		}
		
		//3.插入外村亲属关系
		
		for (Kinship kinship : pm.getOutKinShips()){
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

}
