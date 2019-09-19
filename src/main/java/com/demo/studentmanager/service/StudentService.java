/*
 * RT MAP, Home of Professional MAP
 * Copyright 2019 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.demo.studentmanager.service;

import com.demo.studentmanager.entity.Student;

/**
 * @author lihang@rtmap.com
 * @project student-manager
 * @package com.demo.studentmanager.service
 * @date 2019/9/19
 */
public interface StudentService {
    int add(Student student);
    Student get(int id);
    int edit(Student student);
    int delete(int id);
}
