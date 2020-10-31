package org.example.simple_trigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class SimpleTriggerScheduler {

    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail实例，将该实例与HelloTrigger Class绑定
        JobDetail jobDetail = JobBuilder.newJob(SimpleTriggerJob.class)
                .withIdentity("myJob").build();
        //距离当前时间4s后首次执行任务，之后每隔2s重复执行一次任务
        Date startDate = new Date();
        startDate.setTime(startDate.getTime()+4000);
        Date endDate = new Date();
        endDate.setTime(startDate.getTime()+8000); //8s后停止执行
        //创建一个Trigger实例，定义该Job立即执行，并且每隔两秒钟重复执行一次
        SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                .startAt(startDate).endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        //.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)) //无限执行下去
                        .withRepeatCount(3)) //重复执行三次
                .build();
        //创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }

    public static void main3(String[] args) throws SchedulerException {
        //创建一个JobDetail实例，将该实例与HelloTrigger Class绑定
        JobDetail jobDetail = JobBuilder.newJob(SimpleTriggerJob.class)
                .withIdentity("myJob").build();
        //距离当前时间4s后首次执行任务，之后每隔2s重复执行一次任务
        Date startDate = new Date();
        startDate.setTime(startDate.getTime()+4000);
        //创建一个Trigger实例，定义该Job立即执行，并且每隔两秒钟重复执行一次
        SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                .startAt(startDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2)
                 //.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)) //无限执行下去
                        .withRepeatCount(3)) //重复执行三次
                .build();
        //创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }

    public static void main2(String[] args) throws SchedulerException {
        //创建一个JobDetail实例，将该实例与HelloTrigger Class绑定
        JobDetail jobDetail = JobBuilder.newJob(SimpleTriggerJob.class)
                .withIdentity("myJob").build();
        //距离当前时间4s后执行且仅执行一次任务
        Date startDate = new Date();
        startDate.setTime(startDate.getTime()+4000);
        //创建一个Trigger实例，定义该Job立即执行，并且每隔两秒钟重复执行一次
        SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                .startAt(startDate)
                .build();
        //创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
