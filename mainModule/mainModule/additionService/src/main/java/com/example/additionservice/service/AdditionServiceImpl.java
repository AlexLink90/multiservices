package com.example.additionservice.service;

import com.example.supportmodule.entities.MathResultInfo;
import com.example.supportmodule.enums.OperationType;
import com.example.supportmodule.utils.MathResultInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdditionServiceImpl implements AdditionService {

    @Override
    @Cacheable(value = "additionCache")
    public MathResultInfo calculate(int param1, int param2) {
        log.info("create operation addition, param1: {} and param2: {}", param1, param2);
        return MathResultInfoMapper.toMathResultInfo(param1, param2, OperationType.ADDITION, param1 + param2);
    }
}
//package com.example.additionservice.service;
//
//        import com.example.additionservice.dao.MathOperationRepository;
//        import com.example.supportmodule.dto.DtoMathOperation;
//        import com.example.supportmodule.entities.MathResultInfo;
//        import com.example.supportmodule.enums.OperationType;
//        import com.example.supportmodule.utils.MathResultInfoMapper;
//        import lombok.extern.slf4j.Slf4j;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.cache.annotation.Cacheable;
//        import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//public class AdditionServiceImpl implements AdditionService {
//
//    @Autowired
//    MathOperationRepository mathOperationRepository;
//
//    @Override
//    @Cacheable(value = "additionCache")
//    public DtoMathOperation calculate(int param1, int param2) {
//        log.info("create operation addition, param1: {} and param2: {}", param1, param2);
//        MathResultInfo mathResultInfo = MathResultInfoMapper.toMathResultInfo(param1, param2, OperationType.ADDITION, param1 + param2);
//        MathResultInfo response = mathOperationRepository.save(mathResultInfo);
//        return MathResultInfoMapper.toDtoMathResult(response);
//    }
//}