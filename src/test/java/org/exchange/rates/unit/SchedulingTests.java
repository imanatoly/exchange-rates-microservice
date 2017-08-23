package org.exchange.rates.unit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.Date;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class SchedulingTests {

    private static final long DAY_IN_MS = 24 * 60 * 60 * 1000; // hours * mins * secs * ms

    private static String cronParameter;

    @BeforeClass
    public static void initParam() throws Exception {
        Properties properties = new Properties();
        properties.load(SchedulingTests.class.getClassLoader().getResourceAsStream("application.properties"));
        cronParameter = properties.getProperty("scheduled.execution.cron");
    }

    @Test
    public void schedulingShouldBeAtLeastDaily() {
        CronTrigger trigger = new CronTrigger(cronParameter);
        Date firstExecution = trigger.nextExecutionTime(new SimpleTriggerContext());
        Date nextExecution = trigger.nextExecutionTime(new SimpleTriggerContext(firstExecution, firstExecution, firstExecution));
        long interval = nextExecution.getTime() - firstExecution.getTime();
        assertTrue(interval <= DAY_IN_MS);
    }
}
