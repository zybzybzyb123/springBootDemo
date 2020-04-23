package com.zero.demo.controller;

import com.zero.demo.entity.User;
import com.zero.demo.entity.common.RestResult;
import com.zero.demo.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    public RestResult createUser(@RequestBody String name) {
        RestResult restResult = RestResult.success();

        boolean res = userService.createUser(name);
        restResult.put("res", res);
        return restResult;
    }

}
