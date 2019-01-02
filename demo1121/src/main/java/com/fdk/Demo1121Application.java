package com.fdk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//扫描servlet等相关类所在的包
@ServletComponentScan(basePackages ="com.fdk.config")
@MapperScan("com.fdk.dao")
public class Demo1121Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1121Application.class, args);
    }
}
