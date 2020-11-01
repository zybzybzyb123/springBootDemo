package com.zero.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.demo.service.TestService;

/**
 * @author zero
 * @created on 2019-07-28
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String index() {
        return testService.index();
    }
}
