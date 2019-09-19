/*
 * RT MAP, Home of Professional MAP
 * Copyright 2016 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */

package com.demo.studentmanager.config;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 打印所有请求日志
 * @author mengzhu
 * @date 2019/9/19 15:46
 */
@Aspect
@Component
public class LogAopConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAopConfiguration.class);
    private ThreadLocal<Long> time = new ThreadLocal<>();
    private static final String ERROR_PATH = "/error";

    /**
     * 扫描并监控制定package下的Controller、method
     */
    @Pointcut("execution(* com.demo.studentmanager.controller..*.*(..))")
    public void allMethodsPointcut(){}

    /**
     * 接收到请求，记录请求内容
     * @param joinPoint
     */
    @Before("allMethodsPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String requestURI = request.getRequestURI();
        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ requestURI;
        if (LOGGER.isInfoEnabled()){
            String method = request.getMethod();
            final StringBuilder builder = new StringBuilder("Server has received a message\n");
            builder.append("Class Method: ").append(joinPoint.getSignature().getDeclaringTypeName()).append(".").append(joinPoint.getSignature().getName()).append("\n")
                    .append("RequestUrl: ").append(url).append("\n")
                    .append("Method: ").append(request.getMethod()).append("\n")
                    .append("Accept-Encoding: ").append(request.getHeader("Accept-Encoding")).append("\n")
                    .append("Cache-Control: ").append(request.getHeader("Cache-Control")).append("\n")
                    .append("Content-Length: ").append(request.getHeader("Content-Length")).append("\n")
                    .append("Content-Type: ").append(request.getHeader("Content-Type")).append("\n")
                    .append("RemoteAddr: ").append(request.getRemoteAddr()).append("\n")
                    .append("Request Param: ").append(JSON.toJSONString(request.getParameterMap())).append("\n");
            if (HttpMethod.resolve(method) == HttpMethod.POST){
                if (!requestURI.contains(ERROR_PATH)){
                    builder.append("Request Body: ").append(JSON.toJSONString(joinPoint.getArgs()));
                }
            }
            LOGGER.info(builder.toString());
        }
    }

    /**
     * 表达式Around
     */
    @Around("allMethodsPointcut()")
    public Object aroundAllMethod(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Object retVal = null;
        time.set(System.currentTimeMillis());
        try {
            retVal = pjp.proceed();
        } catch (Throwable e) {
            retVal = e.getMessage();
            throw e;
        } finally {
            Long runningMillis = System.currentTimeMillis() - time.get();
            if (LOGGER.isInfoEnabled()){
                LOGGER.info("[{}ms] [Response Content]:\n{}", runningMillis, retVal);
            }
            time.remove();
        }
        return retVal;
    }


    /**
     *
     * @param joinPoint
     * @param e
     */
//	@AfterThrowing(pointcut = "allMethodsPointcut()", throwing = "e")
//	public void afterThrowing(JoinPoint joinPoint, Exception e) {
//		LOGGER.error(joinPoint.toString() , e);
//	}

}
