package com.demo.studentmanager.controller;

import com.demo.studentmanager.common.model.Result;
import com.demo.studentmanager.common.utils.ResultUtil;
import com.demo.studentmanager.entity.Student;
import com.demo.studentmanager.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "学生相关接口")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    @ApiOperation(value = "添加学生", notes = "学生相关")
    public Result add(@RequestBody Student student){
        return ResultUtil.successData(studentService.add(student));
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询学生列表", notes = "学生相关")
    public Result get(@RequestParam(value = "name",required = false) String name){
        return ResultUtil.successData(studentService.getList(name));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询单个学生", notes = "学生相关")
    public Result get(@PathVariable int id){
        return ResultUtil.successData(studentService.get(id));
    }

    @PutMapping("/edit")
    @ApiOperation(value = "修改学生", notes = "学生相关")
    public Result edit(@RequestBody Student student){
        return ResultUtil.successData(studentService.add(student));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除学生", notes = "学生相关")
    public Result delete(@PathVariable int id){
        return ResultUtil.successData(studentService.delete(id));
    }
}
