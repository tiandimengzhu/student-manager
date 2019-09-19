/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.demo.studentmanager.config;

import com.thetransactioncompany.cors.CORSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 * @author mengzhu
 * @date 2019/9/19 15:44
 */
@SuppressWarnings("ALL")
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 处理跨域
     * @return
     */
    @Bean
    public FilterRegistrationBean getCORSFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CORSFilter());
        registration.setName("CORSFilter");
        registration.addUrlPatterns("/*");
        registration.addInitParameter("cors.allowOrigin", "*");
        registration.addInitParameter("cors.supportedMethods", "OPTIONS, GET, POST, HEAD, PUT, DELETE");
        registration.addInitParameter("cors.supportedHeaders", "Accept, Origin, X-Requested-With, token, JSESSIONID, cookie, Cookie, Content-Type, Last-Modified, Authorization");
        registration.addInitParameter("cors.exposedHeaders", "Set-Cookie");
        registration.addInitParameter("cors.supportsCredentials", "true");
        registration.setOrder(0);
        return registration;
    }
}
