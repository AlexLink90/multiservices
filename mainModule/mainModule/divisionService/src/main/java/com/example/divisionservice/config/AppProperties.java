package com.example.divisionservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config.division.app")
@Getter
@Setter
public class AppProperties {

    private Integer precision;
}
