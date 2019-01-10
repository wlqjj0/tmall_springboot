package com.how2java.tmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//启动类，代替自动生成的 TmallSpringbootApplication.java
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}