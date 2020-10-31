package org.example.scheduler;

import org.joda.time.DateTime;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SchedulerJob implements Job {
    /**
     CronJob表达式： [秒][分][时][日][月][周][年]
    **/
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Hello Scheduler!");
    }
}
