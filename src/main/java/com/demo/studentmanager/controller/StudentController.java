package com.demo.studentmanager.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: cy_li
 * @date: 2019-09-17 21:21
 */
@RestControllerAdvice
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/get")
    public String get(String id){
        return id;
    }
}
