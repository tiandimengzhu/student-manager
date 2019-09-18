package com.demo.studentmanager.common.enums;

import java.util.Map;

/**
 * @author: cy_li
 * @date: 2019-09-17 21:27
 */
public enum DbIsDelEnum {
    EFFECTIVE(0, "有效"),
    INVALID(1, "无效");

    private int status;
    private String desc;

    DbIsDelEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private static Map<Integer, DbIsDelEnum> values = new HashMap<>(2);
    static {
        for (DbIsDelEnum v : DbIsDelEnum.values()) {
            values.put(v.getStatus(), v);
        }
    }

    public static DbIsDelEnum getEnum(Integer status) {
        return values.get(status);
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
