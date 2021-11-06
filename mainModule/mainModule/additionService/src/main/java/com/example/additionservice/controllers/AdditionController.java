package com.example.additionservice.controllers;

import com.example.additionservice.service.AdditionService;
import com.example.supportmodule.entities.MathResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AdditionController {

    AdditionService additionService;

    @Autowired
    public AdditionController(AdditionService additionService) {
        this.additionService = additionService;
    }

    @GetMapping("/{num1}/{num2}")
    public MathResultInfo calculate(@PathVariable int num1, @PathVariable int num2) {
        return additionService.calculate(num1, num2);
    }
}
//package com.example.additionservice.controllers;
//
//        import com.example.additionservice.service.AdditionService;
//        import com.example.supportmodule.dto.DtoMathOperation;
//        import com.example.supportmodule.entities.MathResultInfo;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.bind.annotation.GetMapping;
//        import org.springframework.web.bind.annotation.PathVariable;
//        import org.springframework.web.bind.annotation.RequestMapping;
//        import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/add")
//public class AdditionController {
//
//    AdditionService additionService;
//
//    @Autowired
//    public AdditionController(AdditionService additionService) {
//        this.additionService = additionService;
//    }
//
//    @GetMapping("/{num1}/{num2}")
//    public ResponseEntity<DtoMathOperation> calculate(@PathVariable int num1, @PathVariable int num2) {
//        return new ResponseEntity<>(additionService.calculate(num1, num2), HttpStatus.OK);
//    }
//}
