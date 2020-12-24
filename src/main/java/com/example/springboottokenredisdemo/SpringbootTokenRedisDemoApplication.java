package com.example.springboottokenredisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.controller"})
public class SpringbootTokenRedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTokenRedisDemoApplication.class, args);
    }

}
