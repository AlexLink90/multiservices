package com.example.divisionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DivisionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DivisionServiceApplication.class, args);
    }

}
