package com.sp.questionnaire.service;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

	/**
	 * Query pointman paging.
	 *
	 * @param currentPage the current page
	 * @param pageSize the page size
	 * @param field the field
	 * @param dir the dir
	 * @return the list
	 */
	List<PointMan> queryPointmanPaging(int currentPage, int pageSize, String field, String dir);
	
	XSSFWorkbook downloadAllDatas();
}
