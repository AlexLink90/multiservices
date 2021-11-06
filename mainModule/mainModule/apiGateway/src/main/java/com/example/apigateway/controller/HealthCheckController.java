package com.example.apigateway.controller;

import com.example.apigateway.configuration.HealthCheckConfig;
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
