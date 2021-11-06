package com.example.calculator.web.controllers;

import com.example.calculator.services.CalculatorService;
import com.example.supportmodule.dto.DtoMathOperation;
import com.example.supportmodule.entities.MathResultInfo;
import com.example.supportmodule.utils.MathResultInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class RestControllerAllOperations {

    @Autowired
    private CalculatorService calculatorService;


    @GetMapping("/{operation}/{num1}/{num2}")
    public DtoMathOperation calculate(@PathVariable String operation,
                                      @PathVariable int num1,
                                      @PathVariable int num2) {
        MathResultInfo mathResultInfo = calculatorService.calculate(operation, num1, num2);
        return MathResultInfoMapper.toDtoMathResult(mathResultInfo);
    }
}


//package com.example.calculator.web.controllers;
//
//        import com.example.calculator.services.CalculatorService;
//        import com.example.supportmodule.dto.DtoMathOperation;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/calculator")
//public class RestControllerAllOperations {
//
//    @Autowired
//    private CalculatorService calculatorService;
//
//
//    @GetMapping("/{operation}/{num1}/{num2}")
//    public ResponseEntity<DtoMathOperation> calculate(@PathVariable String operation,
//                                                      @PathVariable int num1,
//                                                      @PathVariable int num2) {
//        return new ResponseEntity<>(calculatorService.calculate(operation, num1, num2), HttpStatus.OK);
//    }
//}
