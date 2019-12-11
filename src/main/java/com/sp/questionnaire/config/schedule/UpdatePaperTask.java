package com.sp.questionnaire.config.schedule;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sp.questionnaire.dao.PaperDao;
import com.sp.questionnaire.entity.Paper;
import com.sp.questionnaire.entity.User;
import com.sp.questionnaire.service.UserService;

/*
 * Author: Seven
 * Email : cpwu@foxmail.com
 * 2018-09-13 Thursday 16:22
 */
@Slf4j
@Component
@Async
//@EnableScheduling
@Service
public class UpdatePaperTask {
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private UserService userService;
    @Autowired

    //static int i;

    /**
     * 每隔N毫秒执行一次
     */
    @Scheduled(fixedRate = 59_000)
    public void scheduled1() throws MessagingException {
        //System.out.println(new Date() + "\t" + Thread.currentThread().getName());
//        Thread.currentThread().getId());
//        i++;
//        Thread.sleep(2000);
//        System.out.println(System.currentTimeMillis() + "\t" + i);
        List<Paper> list = paperDao.queryPaperWithStatus1();
        for (Paper paper : list) {
            String id = paper.getUserId();
            User user = userService.queryUserByID(id);

            Date now = new Date();
            //  在开始问卷的70秒之内，通知用户问卷可达了
            if (now.getTime() - paper.getStartTime().getTime() < 70_000 && now.getTime() - paper.getStartTime().getTime() > 0) {
            }
            //
            if (now.getTime() - paper.getEndTime().getTime() < 70_000 && now.getTime() - paper.getEndTime().getTime() > 0) {
                if (user != null) {
                    paper.setStatus(2);
                    paperDao.updatePaper(paper);
                }
            }


        }
    }
//    @Scheduled(fixedDelay = 5000)
//    public void scheduled2() {
//        System.out.println();
//    }
}
