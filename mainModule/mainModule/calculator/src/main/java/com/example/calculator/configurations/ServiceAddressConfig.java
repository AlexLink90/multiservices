package com.example.calculator.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "config.calculator.service")
@Component
@Getter
@Setter
public class ServiceAddressConfig {

//    public final String URL_ADDITION="/add/{num1}/{num2}";
//    public final String URL_DIVISION="http://division/div/{num1}/{num2}";
//    public final String URL_MULTIPLICATION="http://multiplication/multiply/{num1}/{num2}";
//    public final String URL_SUBTRACTION="http://subtraction/sub/{num1}/{num2}";

    private String addition;
    private String division;
    private String multiplication;
    private String subtraction;

}
