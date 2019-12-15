package com.sp.questionnaire.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Author: Seven
 * Email : cpwu@foxmail.com
 * 2018-07-21 星期六 16:01
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("msg", e.getMessage());
        return map;
    }

    @ExceptionHandler(value = IllegalAccessException.class)
    @ResponseBody
    private Map<String, Object> tokenExpired(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", -1);
        map.put("msg", e.getMessage());
        return map;
    }
}
