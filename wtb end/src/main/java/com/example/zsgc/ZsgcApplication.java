package com.example.zsgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.zsgc.mapper")
public class ZsgcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZsgcApplication.class, args);
    }
}