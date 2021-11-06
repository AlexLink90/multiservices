package com.example.calculator.services;

import com.example.supportmodule.entities.MathResultInfo;

public interface CalculatorService {
    MathResultInfo calculate(String operation, int num1, int num2);
    boolean saveOperation(MathResultInfo mathResultInfo);
}



//package com.example.calculator.services;
//
//        import com.example.supportmodule.dto.DtoMathOperation;
//        import org.springframework.http.ResponseEntity;
//
//public interface CalculatorService {
//    ResponseEntity<DtoMathOperation> calculate(String operation, int num1, int num2);
//}