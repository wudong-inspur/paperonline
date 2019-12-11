package com.sp.questionnaire.dao;

import com.sp.questionnaire.entity.PointMan;

/**
 * description: Author:Xiaowanwan Date:2018/9/13-10:48
 */
public interface PointManDao {

	/**
	 * 插入一条指示者信息.
	 * 
	 * @param pm
	 *            the pm
	 * @return the int
	 */
	int insertPointMan(PointMan pm);

	/**
	 * Query point man by no.
	 *
	 * @param pointmanNo the pointman no
	 * @return the list
	 */
	PointMan queryPointManByNo(String pointmanNo);
}
