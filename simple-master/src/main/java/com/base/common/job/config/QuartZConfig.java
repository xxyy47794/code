package com.base.common.job.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartZConfig {

    /**
     * quartz 启动配置
     */
    @Bean
    public SchedulerFactory quartz() throws SchedulerException {
        // Creating scheduler factory and scheduler
        SchedulerFactory factory = new StdSchedulerFactory("quartz.properties");
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        return factory;
    }
}
