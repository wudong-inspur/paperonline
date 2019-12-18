package com.sp.questionnaire.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.questionnaire.entity.PointMan;
import com.sp.questionnaire.service.PointManService;
import com.sp.questionnaire.utils.CommonUtils;

/*
 * Author: Seven
 * Email : cpwu@foxmail.com
 * 2018-09-15 Saturday 09:43
 */
@Controller
public class PointManController {

    @Autowired
    private PointManService pointManService;

    @Autowired
    private CommonUtils commonUtils;

    /**
     * <P>
     * 录入接口
     * </p>
     * 
     * @param user
     *            ： 映射的实体对象，result：参数校验的结果对象
     * @return JSON字符串
     */
    @ResponseBody
    @RequestMapping(value = "/api/v1/addpm", method = RequestMethod.POST)
    public Map<String, Object> addPm(HttpServletRequest request, @Valid @RequestBody PointMan pm, BindingResult result)
            throws UnsupportedEncodingException, MessagingException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (result.hasErrors()) {
            FieldError error = result.getFieldErrors().get(0);// 获得第第一个错误
            map.put("msg", error.getDefaultMessage());// 将错误信息放入msg
            map.put("code", 2);
            return map;
        }
        if (pointManService.insertPointMan(pm)) { // insert user success
            map.put("code", 0);
            map.put("msg", "ok");
            map.put("data", 0);
        } else {
            map.put("code", 1);
            map.put("msg", "insert database fail");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/api/v1/querypm", method = RequestMethod.GET)
    public Map<String, Object> listPm(HttpServletRequest request,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(name = "field", defaultValue="name") String field, @RequestParam(name = "dir", defaultValue = "asc") String dir)
            throws UnsupportedEncodingException, MessagingException {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> retMap = pointManService.queryPointmanPaging(page, pageSize, field, dir);
        map.put("code", 0);
        map.put("msg", "ok");
        map.put("data", retMap.get("data"));
        map.put("page", page);
        map.put("pageSize", pageSize);
        map.put("total", retMap.get("total"));
        return map;
    }

    /**
     * Export data.
     * 
     * @param request
     *            the request
     * @param res
     *            the res
     * @return the operation result
     * @throws IOException
     *             e
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> exportData(HttpServletRequest request, HttpServletResponse res) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "ok");
        res.setCharacterEncoding("utf-8");
        XSSFWorkbook wb = this.pointManService.downloadAllDatas();
        // 响应头
        res.setContentType("application/x-excel;charset=UTF-8");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setHeader("Expires", "0");
        // 文件名用ISO8859_1编码 解决中文文件名编码问题
        res.setHeader(
                "Content-Disposition",
                "attachment; filename=\""
                        + new String(("导出数据" + commonUtils.getFormatDateTimeNow() + ".xlsx").getBytes(), "ISO8859-1"));
        ServletOutputStream sos = res.getOutputStream();
        wb.write(sos);
        sos.flush();
        sos.close();
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/api/v1/deletepm", method = RequestMethod.POST)
    public Map<String, Object> deletePm(HttpServletRequest request, @RequestParam(name = "pmid") String pmid,
            @Valid @RequestBody PointMan pm, BindingResult result) throws UnsupportedEncodingException,
            MessagingException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (result.hasErrors()) {
            FieldError error = result.getFieldErrors().get(0);// 获得第第一个错误
            map.put("msg", error.getDefaultMessage());// 将错误信息放入msg
            map.put("code", 2);
            return map;
        }
        if (pointManService.deletePointman(pmid)) { // insert user success
            map.put("code", 0);
            map.put("msg", "ok");
            map.put("data", 0);
        } else {
            map.put("code", 1);
            map.put("msg", "insert database fail");
        }
        return map;
    }
}
