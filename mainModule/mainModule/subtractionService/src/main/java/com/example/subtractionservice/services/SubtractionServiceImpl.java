package com.example.subtractionservice.services;

import com.example.supportmodule.entities.MathResultInfo;
import com.example.supportmodule.enums.OperationType;
import com.example.supportmodule.utils.MathResultInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubtractionServiceImpl implements SubtractionService{
    @Override
    @Cacheable(value = "subtractionCache")
    public MathResultInfo calculate(int param1, int param2) {
        log.info("create operation subtraction, param1: {} and param2: {}", param1, param2);
        return MathResultInfoMapper.toMathResultInfo(param1, param2, OperationType.SUBTRACTION, param1 - param2);
        }
    }
