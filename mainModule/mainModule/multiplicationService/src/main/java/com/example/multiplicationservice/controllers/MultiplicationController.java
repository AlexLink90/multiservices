package com.example.multiplicationservice.controllers;

import com.example.multiplicationservice.services.MultiplicationService;
import com.example.supportmodule.entities.MathResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mul")
public class MultiplicationController {

    MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @GetMapping("/{param1}/{param2}")
    public MathResultInfo calculate(@PathVariable int param1, @PathVariable int param2) {
        return multiplicationService.calculate(param1, param2);
    }
}
