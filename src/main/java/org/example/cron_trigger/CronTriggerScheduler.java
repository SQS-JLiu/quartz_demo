package org.example.cron_trigger;

import org.example.simple_trigger.SimpleTriggerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class CronTriggerScheduler {
    /**
     CronJob表达式： [秒][分][时][日][月][周][年]
     字段   是否必填    允许值        允许的特殊字符
      秒     是        0~59           , - * /
      分     是        0~59           , - * /
      时     是        0~23           , - * /
      日     是        1~31           , - * / L W C
      月     是        1~12           , - * /
      周     是        1~7            , - * / L C #
      年     否    empty,1970~2099    , - * /
      #特殊符号： ,逗号代表或(指定多个值)          -代表至(区间)
                *代表每(秒/分/时/日...)的关系    /每隔的关系(用于递增触发)
                ？代表不关心这个取值(不指定值))   # 序号,例如每月的第几周
     例：
     0 15 10 ? * *      每天10点15分触发
     0 0/5 14 * * ?     每天下午2点到2点59分(整点开始, 每隔5分钟触发一次)
     0/5 * 14,18 * * ？  每天14点至14点59分，以及18点至18点59分，每隔5s触发一次
     **/

    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail实例，将该实例与HelloTrigger Class绑定
        JobDetail jobDetail = JobBuilder.newJob(CronJob.class)
                .withIdentity("myJob").build();
        //创建一个Trigger实例，并且每隔1秒钟触发执行一次
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();
        //创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        System.out.println("最近一次要执行任务的时间:");
        System.out.println(scheduler.scheduleJob(jobDetail, trigger));
        scheduler.start();
    }
}
