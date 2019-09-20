/*
 * RT MAP, Home of Professional MAP
 * Copyright 2019 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.demo.studentmanager.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author mengzhu
 * @project student-manager
 * @package com.demo.studentmanager.common.model
 * @date 2019/9/19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 8030573691361330209L;
    private int code;
    private String message;
    private T data;
}