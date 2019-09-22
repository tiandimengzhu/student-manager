/*
 * RT MAP, Home of Professional MAP
 * Copyright 2019 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.demo.studentmanager.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 新版的（Spring Cloud 2.0 以上）security默认启用了csrf检验，要在eureka服务端那边配置security的csrf检验为false
 * @author mengzhu
 * @project student-manager
 * @package com.demo.studentmanager.config
 * @date 2019/8/15
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
