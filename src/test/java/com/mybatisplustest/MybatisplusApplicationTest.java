package com.mybatisplustest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mybatisplustest.*")
@MapperScan(basePackages = "com.mybatisplustest.mapper")
public class MybatisplusApplicationTest {



    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplicationTest.class, args);

    }


}
