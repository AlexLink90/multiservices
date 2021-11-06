package com.example.calculator.services;

import com.example.calculator.exception.OperationNotSupportException;
import com.example.supportmodule.entities.MathResultInfo;
import com.example.supportmodule.enums.OperationType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@SpringBootTest
class CalculatorServiceImplTest {
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final String URL_ADDITIONAL_OPERATION = "http://localhost:8081/add/1/1";
    public static final String URL_DIVISION_OPERATION = "http://localhost:8082/div/1/1";
    public static final String URL_MULTIPLICATION_OPERATION = "http://localhost:8084/multiply/1/1";
    public static final String URL_SUBTRACTION_OPERATION = "http://localhost:8083/sub/1/1";
    private static final String ADDITION_OPERATION = "add";
    private static final String DIVISION_OPERATION = "div";
    private static final String MULTIPLICATION_OPERATION = "multiply";
    private static final String SUBTRACTION_OPERATION = "sub";
    private static final String DEFAULT_OPERATION = "def";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CalculatorService calculatorService;

    private MockRestServiceServer mockRestServiceServer;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void init() {
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
        objectMapper = new ObjectMapper();
    }

    @Test
    void calculateAddition() throws JsonProcessingException {
        MathResultInfo testEntity = new MathResultInfo(ONE, ONE, ONE, OperationType.ADDITION, TWO);
        mockRestServiceServer.expect(ExpectedCount.once(),
                        requestTo(URL_ADDITIONAL_OPERATION))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsString(testEntity)));

        MathResultInfo mathResultInfo = calculatorService.calculate(ADDITION_OPERATION, ONE, ONE);
        Assertions.assertEquals(objectMapper.writeValueAsString(testEntity), objectMapper.writeValueAsString(mathResultInfo));
    }

    @Test
    void calculateDivision() throws JsonProcessingException {
        MathResultInfo testEntity = new MathResultInfo(ONE, ONE, ONE, OperationType.DIVISION, ONE);
        mockRestServiceServer.expect(ExpectedCount.once(),
                        requestTo(URL_DIVISION_OPERATION))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsString(testEntity)));

        MathResultInfo mathResultInfo = calculatorService.calculate(DIVISION_OPERATION, ONE, ONE);
        Assertions.assertEquals(objectMapper.writeValueAsString(testEntity), objectMapper.writeValueAsString(mathResultInfo));
    }

    @Test
    void calculateMultiplication() throws JsonProcessingException {
        MathResultInfo testEntity = new MathResultInfo(ONE, ONE, ONE, OperationType.MULTIPLICATION, ONE);
        mockRestServiceServer.expect(ExpectedCount.once(),
                        requestTo(URL_MULTIPLICATION_OPERATION))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsString(testEntity)));

        MathResultInfo resultEntity = calculatorService.calculate(MULTIPLICATION_OPERATION, ONE, ONE);
        Assertions.assertEquals(objectMapper.writeValueAsString(testEntity), objectMapper.writeValueAsString(resultEntity));
    }

    @Test
    void calculateSubtraction() throws JsonProcessingException {
        MathResultInfo testEntity = new MathResultInfo(ONE, ONE, ONE, OperationType.SUBTRACTION, ONE);
        mockRestServiceServer.expect(ExpectedCount.once(),
                        requestTo(URL_SUBTRACTION_OPERATION))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsString(testEntity)));

        MathResultInfo resultEntity = calculatorService.calculate(SUBTRACTION_OPERATION, ONE, ONE);
        Assertions.assertEquals(objectMapper.writeValueAsString(testEntity), objectMapper.writeValueAsString(resultEntity));
    }

    @Test
    void calculateDefault() {
        Assertions.assertThrows(OperationNotSupportException.class, () -> {
            calculatorService.calculate(DEFAULT_OPERATION, ONE, ONE);
        });
    }
}