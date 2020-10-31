package org.example.trigger;

import org.joda.time.DateTime;
import org.quartz.*;

public class HelloTrigger implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        Trigger currentTrigger = jobExecutionContext.getTrigger();
        System.out.println("Start time:"+currentTrigger.getStartTime());
        System.out.println("End time: " + currentTrigger.getEndTime());
        JobKey jobKey = currentTrigger.getJobKey();
        System.out.println("JobKey info[ jobName:" + jobKey.getName()
                            + ", jobGroup:" + jobKey.getGroup());
    }
}
