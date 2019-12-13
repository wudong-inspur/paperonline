package com.sp.questionnaire.dao;

import java.util.List;

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
	
	/**
	 * Gets the kinship by pointman no.
	 *
	 * @param pointmanNo the pointman no
	 * @return the kinship by pointman no
	 */
	List<Kinship> getKinshipByPointmanNo(String pointmanNo);
}
