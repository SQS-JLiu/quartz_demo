package org.example.job_data;

import org.joda.time.DateTime;
import org.quartz.*;

public class DataJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("My Job name and group are: "
                + jobKey.getName() + ":" + jobKey.getGroup());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String jobMsg = jobDataMap.getString("message");
        Float jobFloatValue = jobDataMap.getFloat("FloatJobValue");
        System.out.println("JobMsg is: " + jobMsg);
        System.out.println("JobFloatValue is: " + jobFloatValue);

        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("My Trigger name and group are: "
                + triggerKey.getName() + ":" + triggerKey.getGroup());
        JobDataMap tJobDataMap = jobExecutionContext.getTrigger().getJobDataMap();
        String triggerMsg = tJobDataMap.getString("message");
        Double doubleTriggerValue = tJobDataMap.getDouble("DoubleTriggerValue");
        System.out.println("TriggerMsg is: " + triggerMsg);
        System.out.println("DoubleTriggerValue is " + doubleTriggerValue);
        System.out.println("======================================");
    }
}
