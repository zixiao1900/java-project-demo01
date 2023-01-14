package com.java_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 支持SpringBootApplication
public class Module5APP { // 去查找controller service等注解 然后创建对象(仅限当前包)
    public static void main(String[] args) {
        SpringApplication.run(Module5APP.class, args); // 运行SpringBoot 程序
    }
}
