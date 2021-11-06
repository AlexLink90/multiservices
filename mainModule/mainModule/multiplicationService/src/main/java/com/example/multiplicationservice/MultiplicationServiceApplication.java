package com.example.multiplicationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MultiplicationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiplicationServiceApplication.class, args);
    }

}
