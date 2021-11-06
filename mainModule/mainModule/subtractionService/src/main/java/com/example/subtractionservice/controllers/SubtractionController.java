package com.example.subtractionservice.controllers;

import com.example.subtractionservice.services.SubtractionService;
import com.example.supportmodule.entities.MathResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sub")
public class SubtractionController {

    SubtractionService subtractionService;

    @Autowired
    public SubtractionController(SubtractionService subtractionService) {
        this.subtractionService = subtractionService;
    }

    @GetMapping("/{param1}/{param2}")
    public MathResultInfo calculate (@PathVariable int param1, @PathVariable int param2) {
        return subtractionService.calculate(param1, param2);
    }
}
