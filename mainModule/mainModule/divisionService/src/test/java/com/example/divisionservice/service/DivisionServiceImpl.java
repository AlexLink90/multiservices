package com.example.divisionservice.service;

import com.example.divisionservice.config.AppProperties;
import com.example.supportmodule.entities.MathResultInfo;
import com.example.supportmodule.enums.OperationType;
import com.example.supportmodule.utils.MathResultInfoMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivisionServiceImpl{

    final AppProperties appProperties = new AppProperties();

    public MathResultInfo calculate(int param1, int param2) {

        int precision = appProperties.getPrecision();

        BigDecimal bigDecimal1 = BigDecimal.valueOf(param1);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(param2);

        BigDecimal divResult = bigDecimal1.divide(bigDecimal2, precision, RoundingMode.HALF_UP);
        return MathResultInfoMapper.toMathResultInfo(param1, param2, OperationType.DIVISION, divResult.doubleValue());
    }
}
