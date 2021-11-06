package com.example.apigateway.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config.apigateway.healthcheck")
@Getter
@Setter
public class HealthCheckConfig {

    private String upMessage;
}
