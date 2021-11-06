package com.example.divisionservice.controllers;

import com.example.divisionservice.service.DivisionService;
import com.example.supportmodule.entities.MathResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/div")
public class DivisionController {

    DivisionService divisionService;

    @Autowired
    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping("/{num1}/{num2}")
    public MathResultInfo calculate(@PathVariable int num1, @PathVariable int num2) {
        return divisionService.calculate(num1, num2);
    }
}
