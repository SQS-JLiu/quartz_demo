package org.example.job_data;

import org.joda.time.DateTime;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobMergedData {

    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail实例，将该实例与HelloHob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(MergedDataJob.class)
                .withIdentity("myJob","JobGroup2")
                .usingJobData("message","hello myJob")
                .usingJobData("FloatJobValue",3.14F)
                .build();
        //创建一个Trigger实例，定义该Job立即执行，并且每隔两秒钟重复执行一次，直到永远
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","triggerGroup2")
                .usingJobData("message","hello myTrigger")
                .usingJobData("DoubleTriggerValue",2.0D)
                .startNow().withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(2).repeatForever()).build();
        //创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
        System.out.println("======================================");
        System.out.println("Task start......");
        System.out.println(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println("======================================");
    }
}
