package com.daoshu.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//import org.flywaydb.core.Flyway;

@Slf4j
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("init.....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
