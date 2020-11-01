package com.zero.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@SpringBootApplication(scanBasePackages = "com.zero.demo")
@MapperScan(basePackages = "com.zero.demo.dao")
@EnableScheduling
@Slf4j
public class SpringBootDemoApplication implements ServletContextInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        servletContext.setInitParameter("logbackDisableServletContainerInitializer", "true");
    }
}
