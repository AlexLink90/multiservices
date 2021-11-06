package com.example.calculator.web.controllers;

import com.example.calculator.configurations.HealthCheckConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @Autowired
    HealthCheckConfig healthCheckConfig;

    @GetMapping
    public String healthCheck() {
        return healthCheckConfig.getUpMessage();
    }
}
