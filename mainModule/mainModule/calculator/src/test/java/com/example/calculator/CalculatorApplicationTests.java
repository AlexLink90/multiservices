package com.example.calculator;

import com.example.calculator.configurations.ServiceAddressConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorApplicationTests {

    @Autowired
    ServiceAddressConfig serviceAddressConfig;


    @Test
    void contextLoads() {
    }

}
