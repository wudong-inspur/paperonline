package com.sp.questionnaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.questionnaire.dao.PointManDao;
import com.sp.questionnaire.entity.PointMan;
import com.sp.questionnaire.service.PointManService;

@Service
public class PointManServiceImpl implements PointManService {
	
	@Autowired
	private PointManDao pmDao;
	
	@Transactional
	@Override
	public boolean insertPointMan(PointMan pm) {
        if (pm != null && !"".equals(pm.getId())) {
            try {
                int i = pmDao.insertPointMan(pm);
                if (i == 1) {
                    return true;
                } else {
                    throw new RuntimeException("a:插入指示者失败！" + pm);
                }
            } catch (Exception e) {
                throw new RuntimeException("b:插入指示者失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("c:插入指示者失败，指示者id不能为空！");
        }
	}

}
