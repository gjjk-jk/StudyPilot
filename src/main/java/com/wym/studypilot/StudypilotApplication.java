package com.wym.studypilot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wym.studypilot.mapper")
public class StudypilotApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudypilotApplication.class, args);
    }
}