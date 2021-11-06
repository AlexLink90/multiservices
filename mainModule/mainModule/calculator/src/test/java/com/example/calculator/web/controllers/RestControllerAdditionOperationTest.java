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

@WireMockTest(httpPort = 8081)
@SpringBootTest
@AutoConfigureMockMvc
class RestControllerAdditionOperationTest {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final String CONTENT_TYPE = "application/json";
    public static final int STATUS_OK = 200;

    public final String PATH_ADDITION_TO_CONTROLLER = "/calculator/add/1/1";
    public final String PATH_ADDITION_TO_SERVICE = "/add/1/1";
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;
    private String expectedResult;

    @BeforeEach
    public void init() throws JsonProcessingException {
        MathResultInfo mathResultInfo = new MathResultInfo(ONE,ONE, ONE, OperationType.ADDITION, TWO);
        objectMapper = new ObjectMapper();
        expectedResult = objectMapper.writeValueAsString(mathResultInfo);
    }

    @Test
    void calculate() throws Exception {
        stubFor(get(PATH_ADDITION_TO_SERVICE)
                .willReturn(aResponse()
                        .withBody(expectedResult)
                        .withHeader("Content-Type", CONTENT_TYPE)
                        .withStatus(STATUS_OK)));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(PATH_ADDITION_TO_CONTROLLER)
        ).andReturn();
        String mvcResultToString = mvcResult.getResponse().getContentAsString();
        assertNotNull(mvcResult);
        assertEquals(expectedResult, mvcResultToString);
    }
}
//    private String convertEntityToString(InputStream inputStream) {
//        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
//        String string = scanner.useDelimiter("\\Z").next();
//        scanner.close();
//        return string;
//    }
