package com.example.supportmodule.dto;

import com.example.supportmodule.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoMathOperation {
    private OperationType operationType;
    private int numberOne;
    private int numberTwo;
    private double result;
    private LocalDateTime createdDate;
    private LocalDateTime timeDefault;
}
