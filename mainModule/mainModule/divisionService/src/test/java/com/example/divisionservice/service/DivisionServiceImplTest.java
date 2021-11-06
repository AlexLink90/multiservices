package com.example.divisionservice.service;


import com.example.divisionservice.config.AppProperties;
import com.example.supportmodule.entities.MathResultInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;


public class DivisionServiceImplTest {

    public final int TEN = 10;
    public final int THREE = 3;
    public final double EXPECT_RESULT = 3.333;
    public final int EXPECT_PRECISION = 3;
    AppProperties appProperties = new AppProperties();
    DivisionServiceImpl divisionService = new DivisionServiceImpl();



    @Test
    void calculate() {
        MathResultInfo actual = divisionService.calculate(TEN, THREE);
        Assertions.assertEquals(EXPECT_RESULT, actual.getResult());
    }

    @Test
    void checkPrecision() {
        Assertions.assertEquals(EXPECT_PRECISION, appProperties.getPrecision());
    }
}