package com.sp.questionnaire.service;

import com.sp.questionnaire.entity.PointMan;

/**
 * The Interface PointManService.
 */
public interface PointManService {

	/**
	 * Insert point man.
	 * 
	 * @param pm
	 *            the pm
	 * @return true, if successful
	 */
	boolean insertPointMan(PointMan pm);

	/**
	 * Query point man by no.
	 * 
	 * @param pointmanNo
	 *            the pointman no
	 * @return the point man
	 */
	PointMan queryPointManByNo(String pointmanNo);
}
