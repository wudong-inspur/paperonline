package com.sp.questionnaire.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.sp.questionnaire.entity.PointMan;

/**
 * The Class DataWriter.
 */
public class DataWriter {

    /** The log. */
    Logger log = Logger.getLogger(DataWriter.class);

    /**
     * Write2 excel.
     * 
     * @param datas
     *            the datas
     * @return the string
     * @throws CloudBusinessException
     *             e
     */
    public HSSFWorkbook write2Excel(List<PointMan> datas) throws Exception {
        String path = DataWriter.class.getResource("/").getPath();
        File templateFile = new File(path + "template.xls");
        HSSFWorkbook wb = null;
        try {
            InputStream input = new FileInputStream(templateFile);
            wb = new HSSFWorkbook(input);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new Exception("");
        }
        writeData2Workbook(datas, wb);
        return wb;
    }

    /**
     * Write data2 sheet.
     * 
     * @param datas
     *            the datas
     * @param wb
     *            the wb
     */
    private void writeData2Workbook(List<PointMan> datas, HSSFWorkbook wb) {

    }

    /**
     * Write first visit2 row.
     * 
     * @param wb
     *            the wb
     * @param caseModel
     *            the case model
     * @param rowIndex
     *            the row index
     */
    private void writeFirstVisit2Row(HSSFWorkbook wb, PointMan pointman, int rowIndex) {
        HSSFSheet firstVisitSheet = wb.getSheet("指示者信息");
        HSSFRow row = firstVisitSheet.createRow(rowIndex);
        row.createCell(0).setCellValue(pointman.getAddr());

    }
}
