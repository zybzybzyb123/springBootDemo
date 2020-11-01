package com.zero.demo;

import com.zero.demo.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTest {

    @Autowired
    private TestService testService;

    @Before
    public void init() {

    }

    @Test
    public void test() {
        System.out.println(testService.index());;
    }
}
