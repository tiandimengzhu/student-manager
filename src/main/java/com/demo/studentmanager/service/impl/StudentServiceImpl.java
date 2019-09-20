/*
 * RT MAP, Home of Professional MAP
 * Copyright 2019 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.demo.studentmanager.service.impl;

import com.demo.studentmanager.dao.StudentMapper;
import com.demo.studentmanager.entity.Student;
import com.demo.studentmanager.entity.StudentExample;
import com.demo.studentmanager.service.StudentService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mengzhu
 * @project student-manager
 * @package com.demo.studentmanager.service.impl
 * @date 2019/9/19
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public Student get(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> getList(String name) {
        StudentExample studentExample = new StudentExample();
        if(StringUtils.isNotBlank(name)){
            studentExample.createCriteria().andNameLike(name);
        }
        return studentMapper.selectByExample(studentExample);
    }

    @Override
    public int edit(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int delete(int id) {
        return studentMapper.deleteByPrimaryKey(id);
    }
}
