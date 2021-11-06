package com.example.calculator.web.controllers;

import com.example.supportmodule.entities.MathResultInfo;
import com.example.supportmodule.enums.OperationType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@WireMockTest(httpPort = 8082)
@SpringBootTest
@AutoConfigureMockMvc
class RestControllerDivisionOperationTest {

    public final String PATH_DIVISION_TO_CONTROLLER = "/calculator/div/2/2";
    public final String PATH_DIVISION_TO_SERVICE = "/div/2/2";
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;
    private String result;

    @BeforeEach
    public void init() throws JsonProcessingException {
        MathResultInfo mathResultInfo = new MathResultInfo(
                RestControllerAdditionOperationTest.ONE,
                RestControllerAdditionOperationTest.TWO,
                RestControllerAdditionOperationTest.TWO,
                OperationType.DIVISION,
                RestControllerAdditionOperationTest.ONE
                );
        objectMapper = new ObjectMapper();
        result = objectMapper.writeValueAsString(mathResultInfo);
    }

    @Test
    void calculate() throws Exception {
        stubFor(get(PATH_DIVISION_TO_SERVICE)
                .willReturn(aResponse()
                        .withStatus(RestControllerAdditionOperationTest.STATUS_OK)
                        .withBody(result)
                        .withHeader("Content-Type", RestControllerAdditionOperationTest.CONTENT_TYPE)));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(PATH_DIVISION_TO_CONTROLLER)
        ).andReturn();
        String mvcResultToString = mvcResult.getResponse().getContentAsString();
        assertNotNull(mvcResult);
        assertEquals(result, mvcResultToString);
    }
}
