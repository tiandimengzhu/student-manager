package com.demo.studentmanager.controller;

import com.demo.studentmanager.common.model.Result;
import com.demo.studentmanager.common.utils.ResultUtil;
import com.demo.studentmanager.entity.Student;
import com.demo.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @RequestMapping(method = RequestMethod.POST)  Create
 * @RequestMapping(method = RequestMethod.GET)   Read
 * @RequestMapping(method = RequestMethod.PUT)   Update
 * @RequestMapping(method = RequestMethod.DELETE)  Delete
 *
 * @author: cy_li
 * @date: 2019-09-17 21:21
 */
@RestControllerAdvice
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Result add(@RequestBody Student student){
        return ResultUtil.successData(studentService.add(student));
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable int id){
        return ResultUtil.successData(studentService.get(id));
    }

    @PutMapping("/edit")
    public Result edit(@RequestBody Student student){
        return ResultUtil.successData(studentService.add(student));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return ResultUtil.successData(studentService.delete(id));
    }
}
