package com.zero.demo.service.impl;

import com.zero.demo.dao.UserMapper;
import com.zero.demo.entity.User;
import com.zero.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zero
 * @created 2020/04/12
 */
@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserMapper userMapper;

    @Override
    public User getById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public boolean createUser(String name) {
        long now = System.currentTimeMillis();
        return userMapper.createUser(name, now, now) > 0;
    }
}
