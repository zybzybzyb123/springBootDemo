package com.zero.demo.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author zero
 * @created 2019/10/16
 */
@Lazy
@Service
public class TestService {
    private static final String INDEX = "Hello World";

    public String index() {
        return INDEX;
    }
}
