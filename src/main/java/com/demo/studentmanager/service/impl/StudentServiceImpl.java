/*
 * RT MAP, Home of Professional MAP
 * Copyright 2019 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.demo.studentmanager.service.impl;

import com.demo.studentmanager.entity.Student;
import com.demo.studentmanager.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author mengzhu
 * @project student-manager
 * @package com.demo.studentmanager.service.impl
 * @date 2019/9/19
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public int add(Student student) {
        return 0;
    }

    @Override
    public Student get(int id) {
        return null;
    }

    @Override
    public int edit(Student student) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
