/*
 * RT MAP, Home of Professional MAP
 * Copyright 2019 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.demo.studentmanager.common.utils;

import com.demo.studentmanager.common.model.Result;
import org.springframework.http.HttpStatus;

/**
 * 返回实体封装的工具类
 * @author mengzhu
 * @project student-manager
 * @package com.demo.studentmanager.common.utils
 * @date 2019/9/19
 */
public class ResultUtil {
    /**
     * 公共私有静态函数
     * @param code
     * @param msg
     * @return
     */
    private static Result commonBuild(int code , String msg,Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }

    public static Result success(String msg,Object data){
        return commonBuild(HttpStatus.OK.value(),msg,data);
    }

    public static Result success(String msg){
        return success(msg,null);
    }

    public static Result successData(Object data){
        return success("请求成功",data);
    }

    public static Result success(){
        return success("请求成功");
    }

    public static Result error(String msg,Object data){
        return commonBuild(HttpStatus.INTERNAL_SERVER_ERROR.value(),msg,data);
    }

    public static Result error(String msg){
        return error(msg,null);
    }

    public static Result errorData(Object data){
        return error("请求失败",data);
    }

    public static Result error(){
        return success("请求失败");
    }
}
