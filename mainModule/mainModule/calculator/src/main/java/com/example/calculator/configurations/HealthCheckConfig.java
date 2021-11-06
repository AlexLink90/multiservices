package com.example.calculator.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config.calculator.healthcheck")
@Setter
@Getter
public class HealthCheckConfig {

    private String upMessage;
}
