package org.example.job_data;

import org.joda.time.DateTime;
import org.quartz.*;

public class SetDataJob implements Job {
    private String triggerMessage;
    private String jobMessage;
    private Float floatJobValue;
    private Double doubleTriggerValue;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //通过set来传参
        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("My Job name and group are: "
                + jobKey.getName() + ":" + jobKey.getGroup());
        System.out.println("JobMsg is: " + getJobMessage());
        System.out.println("JobFloatValue is: " + getFloatJobValue());

        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("My Trigger name and group are: "
                + triggerKey.getName() + ":" + triggerKey.getGroup());
        System.out.println("TriggerMsg is: " + getTriggerMessage());
        System.out.println("DoubleTriggerValue is " + getDoubleTriggerValue());
        System.out.println("======================================");
    }

    public String getTriggerMessage() {
        return triggerMessage;
    }

    public void setTriggerMessage(String triggerMessage) {
        this.triggerMessage = triggerMessage;
    }

    public String getJobMessage() {
        return jobMessage;
    }

    public void setJobMessage(String jobMessage) {
        this.jobMessage = jobMessage;
    }

    public Float getFloatJobValue() {
        return floatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        this.floatJobValue = floatJobValue;
    }

    public Double getDoubleTriggerValue() {
        return doubleTriggerValue;
    }

    public void setDoubleTriggerValue(Double doubleTriggerValue) {
        this.doubleTriggerValue = doubleTriggerValue;
    }
}
