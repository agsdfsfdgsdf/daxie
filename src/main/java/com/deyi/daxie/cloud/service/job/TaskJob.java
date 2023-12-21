package com.deyi.daxie.cloud.service.job;

import com.deyi.daxie.cloud.service.listener.LessonMsgService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component("taskJob")
public class TaskJob {
    @Resource
    private LessonMsgService lessonMsgService;

    @Scheduled(cron = "0 0 22 * * ?")
    public void logoutJob() {
        lessonMsgService.logoutJob();
        System.out.println("通过cron定义的定时任务");
    }
}
