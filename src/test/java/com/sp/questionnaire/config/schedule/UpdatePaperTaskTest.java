package com.sp.questionnaire.config.schedule;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.questionnaire.dao.PaperDao;
import com.sp.questionnaire.entity.Paper;
import com.sp.questionnaire.entity.User;
import com.sp.questionnaire.service.UserService;

/*
 * Author: Seven
 * Email : cpwu@foxmail.com
 * 2018-09-20 Thursday 22:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdatePaperTaskTest {
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private UserService userService;
    @Test
    public void scheduled1() {
        List<Paper> list = paperDao.queryPaperWithStatus1();
        //System.err.println(list.size());
        for (Paper paper : list) {
            String id = paper.getUserId();
            User user = userService.queryUserByID(id);
            //mailUtils.sendPaperStartMail(user.getEmail(), user.getUsername(), paper);
            //System.err.println(user + "\t" + paper);
        }
    }
}