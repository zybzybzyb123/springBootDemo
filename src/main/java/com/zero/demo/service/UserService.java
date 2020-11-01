package com.zero.demo.service;

import com.zero.demo.entity.User;

/**
 * @author zero
 * @created 2020/04/12
 */
public interface UserService {

    User getById(int id);

    boolean createUser(String name);
}
