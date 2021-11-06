package com.example.divisionservice.service;

import com.example.divisionservice.config.AppProperties;
import com.example.supportmodule.entities.MathResultInfo;
import com.example.supportmodule.enums.OperationType;
import com.example.supportmodule.utils.MathResultInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@Service
public class DivisionServiceImpl implements DivisionService {

    final AppProperties appProperties;

    @Autowired
    public DivisionServiceImpl(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    @Cacheable(value = "divisionCache")
    public MathResultInfo calculate(int param1, int param2) {

        Integer precision = appProperties.getPrecision();

        BigDecimal bigDecimal1 = BigDecimal.valueOf(param1);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(param2);

        BigDecimal divResult = bigDecimal1.divide(bigDecimal2, precision, RoundingMode.HALF_UP);

        log.info("create operation division, param1: {} and param2: {}", param1, param2);
        return MathResultInfoMapper.toMathResultInfo(param1, param2, OperationType.DIVISION, divResult.doubleValue());
    }
}
