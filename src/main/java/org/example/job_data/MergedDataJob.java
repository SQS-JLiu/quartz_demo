package org.example.job_data;

import org.joda.time.DateTime;
import org.quartz.*;

public class MergedDataJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取合并的参数(job和trigger的数据合并，如果存在key相同的数据，
        // 则trigger的会覆盖job的相同key的数据)
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();

        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("My Job name and group are: "
                + jobKey.getName() + ":" + jobKey.getGroup());
        String jobMsg = jobDataMap.getString("message");
        Float jobFloatValue = jobDataMap.getFloat("FloatJobValue");
        System.out.println("JobMsg is: " + jobMsg);
        System.out.println("JobFloatValue is: " + jobFloatValue);

        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("My Trigger name and group are: "
                + triggerKey.getName() + ":" + triggerKey.getGroup());

        String triggerMsg = jobDataMap.getString("message");
        Double doubleTriggerValue = jobDataMap.getDouble("DoubleTriggerValue");
        System.out.println("TriggerMsg is: " + triggerMsg);
        System.out.println("DoubleTriggerValue is " + doubleTriggerValue);
        System.out.println("======================================");
    }
}
