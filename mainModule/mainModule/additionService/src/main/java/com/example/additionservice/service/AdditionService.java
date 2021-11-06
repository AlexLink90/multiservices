package com.example.additionservice.service;

import com.example.supportmodule.entities.MathResultInfo;

public interface AdditionService {
    MathResultInfo calculate(int param1, int param2);
}

//package com.example.additionservice.service;
//
//        import com.example.supportmodule.dto.DtoMathOperation;
//
//public interface AdditionService {
//    DtoMathOperation calculate(int param1, int param2);
//}
