package com.sp.questionnaire.dao;

import com.sp.questionnaire.entity.Kinship;

/**
 * The Interface KinShipDao.
 */
public interface KinShipDao {

	/**
	 * Insert kin ship.
	 * 
	 * @param kinship
	 *            the kinship
	 * @return the int
	 */
	int insertKinShip(Kinship kinship);
}
