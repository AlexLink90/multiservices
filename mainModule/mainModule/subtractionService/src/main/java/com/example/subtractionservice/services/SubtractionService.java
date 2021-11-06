package com.example.subtractionservice.services;

import com.example.supportmodule.entities.MathResultInfo;

import java.util.regex.MatchResult;

public interface SubtractionService {
    MathResultInfo calculate(int param1, int param2);
}
