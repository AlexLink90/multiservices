package com.example.additionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AdditionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdditionServiceApplication.class, args);
    }

}
