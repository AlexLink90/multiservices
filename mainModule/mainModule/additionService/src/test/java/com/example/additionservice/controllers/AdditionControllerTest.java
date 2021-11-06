package com.example.additionservice.controllers;

import com.example.supportmodule.entities.MathResultInfo;
import com.example.supportmodule.enums.OperationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
class AdditionControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @Test
    void calculate() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/add/2/3")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        String mvcResultToString = mvcResult.getResponse().getContentAsString();
        MathResultInfo expectEntity = new MathResultInfo(1,2, 3, OperationType.ADDITION, 5);
        objectMapper = new ObjectMapper();
        Assertions.assertEquals(objectMapper.writeValueAsString(expectEntity), mvcResultToString);
    }
}