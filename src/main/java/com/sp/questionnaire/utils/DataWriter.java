package com.sp.questionnaire.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.questionnaire.dao.KinShipDao;
import com.sp.questionnaire.entity.Kinship;
import com.sp.questionnaire.entity.PointMan;

/**
 * The Class DataWriter.
 */
@Component
public class DataWriter {

    /** The log. */
    Logger log = Logger.getLogger(DataWriter.class);

    @Autowired
    private KinShipDao kinShipDao;

    /**
     * Write2 excel.
     * 
     * @param datas
     *            the datas
     * @return the string
     * @throws CloudBusinessException
     *             e
     */
    public XSSFWorkbook writePointman2Excel(List<PointMan> datas) throws Exception {
        String path = DataWriter.class.getResource("/").getPath();
        File templateFile = new File(path + "template/template.xlsx");

        XSSFWorkbook wb = null;
        try {
            InputStream input = new FileInputStream(templateFile);
            wb = new XSSFWorkbook(input);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new Exception("写入数据失败");
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
    private void writeData2Workbook(List<PointMan> datas, XSSFWorkbook wb) {
        for (PointMan man : datas) {
            writePointmanInfo(wb, man);
            writePmRelInfo(wb, man);
        }

    }

    private void writePmRelInfo(XSSFWorkbook wb, PointMan man) {
        XSSFSheet basicSheet = wb.getSheet("指示者关系人员");
        XSSFCellStyle css = setCellStyle(wb);
        List<Kinship> allKins = kinShipDao.getKinshipByPointmanNo(man.getPointManNo());
        for (Kinship ks : allKins) {
            XSSFRow row = basicSheet.createRow(basicSheet.getLastRowNum() + 1);

            XSSFCell cell0 = row.createCell(0);
            cell0.setCellStyle(css);
            cell0.setCellValue(man.getPointManNo());

            XSSFCell cell1 = row.createCell(1);
            cell1.setCellStyle(css);
            cell1.setCellValue(man.getName());
            
            XSSFCell cell2 = row.createCell(2);
            cell2.setCellStyle(css);
            cell2.setCellValue(ks.isInCountry());
            
            XSSFCell cell3 = row.createCell(3);
            cell3.setCellStyle(css);
            cell3.setCellValue(ks.getName());
            
            XSSFCell cell4 = row.createCell(4);
            cell4.setCellStyle(css);
            cell4.setCellValue(ks.getSex());
        
            XSSFCell cell5 = row.createCell(5);
            cell5.setCellStyle(css);
            cell5.setCellValue(ks.getBirthdate());
            
            XSSFCell cell6 = row.createCell(6);
            cell6.setCellStyle(css);
            cell6.setCellValue(ks.getIdcardNo());
            
            XSSFCell cell7 = row.createCell(7);
            cell7.setCellStyle(css);
            cell7.setCellValue(ks.getRemark());
        }
       
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
    private void writePointmanInfo(XSSFWorkbook wb, PointMan pointman) {
        XSSFSheet basicSheet = wb.getSheet("指示者信息");
        XSSFCellStyle css = setCellStyle(wb);
        XSSFRow row = basicSheet.createRow(basicSheet.getLastRowNum() + 1);

        XSSFCell cell0 = row.createCell(0);
        cell0.setCellStyle(css);
        cell0.setCellValue(pointman.getAddr());
        XSSFCell cell1 = row.createCell(1);
        cell1.setCellStyle(css);
        cell1.setCellValue(pointman.getInputUser());
        XSSFCell cell2 = row.createCell(2);
        cell2.setCellStyle(css);
        cell2.setCellValue(formatDate(pointman.getInputDate(), "yyyy-MM-dd"));
        XSSFCell cell3 = row.createCell(3);
        cell3.setCellStyle(css);
        cell3.setCellValue(pointman.getPointManNo());
        XSSFCell cell4 = row.createCell(4);
        cell4.setCellStyle(css);
        cell4.setCellValue(pointman.getName());
        XSSFCell cell5 = row.createCell(5);
        cell5.setCellStyle(css);
        cell5.setCellValue(pointman.getSex());
        XSSFCell cell6 = row.createCell(6);
        cell6.setCellStyle(css);
        cell6.setCellValue(pointman.getHealthy());
        XSSFCell cell7 = row.createCell(7);
        cell7.setCellStyle(css);
        cell7.setCellValue(pointman.getInCurrentCountry());
        XSSFCell cell8 = row.createCell(8);
        cell8.setCellStyle(css);
        cell8.setCellValue(pointman.getBirthDate());
        XSSFCell cell9 = row.createCell(9);
        cell9.setCellStyle(css);
        cell9.setCellValue(pointman.getCurrentAddr());
        XSSFCell cell10 = row.createCell(10);
        cell10.setCellStyle(css);
        cell10.setCellValue(pointman.getIdCardNo());
        XSSFCell cell11 = row.createCell(11);
        cell11.setCellStyle(css);
        cell11.setCellValue(pointman.getMobilePhone());
        XSSFCell cell12 = row.createCell(12);
        cell12.setCellStyle(css);
        cell12.setCellValue(pointman.getIsOtherPointmanRel());
        XSSFCell cell13 = row.createCell(13);
        cell13.setCellStyle(css);
        cell13.setCellValue(pointman.getOtherPointmanName());
        XSSFCell cell14 = row.createCell(14);
        cell14.setCellStyle(css);
        cell14.setCellValue(pointman.getOtherPointmanRel());

    }

    private XSSFCellStyle setCellStyle(XSSFWorkbook wb) {
        XSSFCellStyle css = wb.createCellStyle();
        // 设置下边框
        css.setBorderBottom(BorderStyle.THIN);
        // 设置上边框
        css.setBorderTop(BorderStyle.THIN);
        // 设置走边框
        css.setBorderLeft(BorderStyle.THIN);
        // 设置右边框
        css.setBorderRight(BorderStyle.THIN);
        return css;
    }

    private String formatDate(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
}
