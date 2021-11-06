//package com.example.additionservice.service;
//
//import com.example.supportmodule.entities.MathResultInfo;
//import com.example.supportmodule.enums.OperationType;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class AdditionServiceImplTest {
//
//    @Autowired
//    AdditionService additionService;
//
//    @Test
//    void calculate() {
//        MathResultInfo expectEntity = new MathResultInfo(1, 1, OperationType.ADDITION, 2);
//        MathResultInfo resultEntity = additionService.calculate(1, 1);
//        Assertions.assertEquals(expectEntity.getResult(),resultEntity.getResult());
//    }
//}