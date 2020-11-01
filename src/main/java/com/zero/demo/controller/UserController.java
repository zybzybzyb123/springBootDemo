package com.zero.demo.controller;

import com.zero.demo.common.util.ObjectMapperUtils;
import com.zero.demo.entity.User;
import com.zero.demo.entity.common.RestResult;
import com.zero.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zero
 * @created on 2019-07-28
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        User user = userService.getById(id);
        log.info("user={}", ObjectMapperUtils.toJSON(user));
        return user;
    }

    @PostMapping
    public RestResult createUser(@RequestBody String name) {
        RestResult restResult = RestResult.success();

        boolean res = userService.createUser(name);
        restResult.put("res", res);
        return restResult;
    }

}
