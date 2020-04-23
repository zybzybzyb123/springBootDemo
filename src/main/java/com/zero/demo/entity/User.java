package com.zero.demo.entity;

import lombok.Data;

/**
 * @author zero
 * @created 2020/04/12
 */
@Data
public class User {

    private long id;
    private String name;
    private long createTime;
    private long updateTime;
}
