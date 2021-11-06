package com.example.supportmodule.utils;

import com.example.supportmodule.dto.DtoMathOperation;
import com.example.supportmodule.entities.MathResultInfo;
import com.example.supportmodule.enums.OperationType;

public class MathResultInfoMapper {

    static public MathResultInfo toMathResultInfo(int param1, int param2, OperationType operation, double result) {
        MathResultInfo mathResultInfo = new MathResultInfo();
        mathResultInfo.setOperandOne(param1);
        mathResultInfo.setOperandTwo(param2);
        mathResultInfo.setOperation(operation);
        mathResultInfo.setResult(result);
        return mathResultInfo;
    }

    static public DtoMathOperation toDtoMathResult(MathResultInfo mathResultInfo) {
        DtoMathOperation dtoMathOperation = new DtoMathOperation();
        dtoMathOperation.setNumberOne(mathResultInfo.getOperandOne());
        dtoMathOperation.setNumberTwo(mathResultInfo.getOperandTwo());
        dtoMathOperation.setOperationType(mathResultInfo.getOperation());
        dtoMathOperation.setResult(mathResultInfo.getResult());
        dtoMathOperation.setCreatedDate(mathResultInfo.getCreatedDate().toLocalDateTime());
        dtoMathOperation.setTimeDefault(mathResultInfo.getTimeDefault().toLocalDateTime());
        return dtoMathOperation;
    }
}