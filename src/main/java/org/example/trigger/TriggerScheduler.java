package org.example.trigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class TriggerScheduler {

    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail实例，将该实例与HelloTrigger Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloTrigger.class)
                .withIdentity("myJob").build();
        Date startDate = new Date();
        startDate.setTime(startDate.getTime() + 3000); //3s后执行任务
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 6000); //6s后停止任务
        //创建一个Trigger实例，定义该Job立即执行，并且每隔两秒钟重复执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2).repeatForever()).build();
        //创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
