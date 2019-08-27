package com.daoshu.config;

import com.daoshu.listener.MyListener;
import com.daoshu.utils.SpringBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MyServerConfig {

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }
    //配置SpringBeanUtils
    @Bean
    public SpringBeanUtils springBeanUtils(){
         log.debug("配置SpringBeanUtils");
         return new SpringBeanUtils();
    }

}
