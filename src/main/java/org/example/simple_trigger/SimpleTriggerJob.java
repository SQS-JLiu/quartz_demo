package org.example.simple_trigger;

import org.joda.time.DateTime;
import org.quartz.*;

public class SimpleTriggerJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        Trigger currentTrigger = jobExecutionContext.getTrigger();
        System.out.println("Hello Simple Trigger!!!");
    }
}
