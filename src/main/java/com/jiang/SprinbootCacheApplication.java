package com.jiang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.jiang.mapper")
@SpringBootApplication
public class SprinbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprinbootCacheApplication.class, args);
    }

}
