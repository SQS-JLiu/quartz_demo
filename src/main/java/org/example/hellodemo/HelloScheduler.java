package org.example.hellodemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail实例，将该实例与HelloHob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob","JobGroup1").build();
        System.out.println(jobDetail.getKey().getName());
        System.out.println(jobDetail.getKey().getGroup());
        System.out.println(jobDetail.getJobClass().getName());
        //创建一个Trigger实例，定义该Job立即执行，并且每隔两秒钟重复执行一次，直到永远
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","triggerGroup1")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2).repeatForever()).build();
        //创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

    }
}
