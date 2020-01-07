package com.sp.questionnaire.service;

import java.util.Map;

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
	 * Query point man by id.
	 *
	 * @param id the id
	 * @return the point man
	 */
	PointMan queryPointManById(String id);

	/**
	 * Query pointman paging.
	 *
	 * @param currentPage the current page
	 * @param pageSize the page size
	 * @param field the field
	 * @param dir the dir
	 * @return the list
	 */
	Map<String, Object> queryPointmanPaging(int currentPage, int pageSize, String field, String dir);
	
	/**
	 * Download all datas.
	 *
	 * @return the xSSF workbook
	 */
	XSSFWorkbook downloadAllDatas();
	
	boolean deletePointman(String pmid);
}
