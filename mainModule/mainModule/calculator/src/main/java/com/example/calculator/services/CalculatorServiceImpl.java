package com.example.calculator.services;

import com.example.calculator.configurations.ServiceAddressConfig;
import com.example.calculator.dao.MathOperationRepository;
import com.example.calculator.exception.OperationNotSupportException;
import com.example.supportmodule.entities.MathResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    final RestTemplate template;
    final ServiceAddressConfig serviceAddressConfig;
    private final MathOperationRepository mathOperationRepository;
    private MathResultInfo response;


    @Autowired
    public CalculatorServiceImpl(RestTemplate template, ServiceAddressConfig serviceAddressConfig, MathOperationRepository mathOperationRepository) {
        this.template = template;
        this.serviceAddressConfig = serviceAddressConfig;
        this.mathOperationRepository = mathOperationRepository;
    }

    @Override
    public MathResultInfo calculate(String operation, int num1, int num2) {
        switch (operation) {
            case "add":
                response = template.getForObject(
                        serviceAddressConfig.getAddition(), MathResultInfo.class, num1, num2);
                break;
            case "div":
                response = template.getForObject(
                        serviceAddressConfig.getDivision(), MathResultInfo.class, num1, num2);
                break;
            case "mul":
                response = template.getForObject(
                        serviceAddressConfig.getMultiplication(), MathResultInfo.class, num1, num2);
                break;
            case "sub":
                response = template.getForObject(
                        serviceAddressConfig.getSubtraction(), MathResultInfo.class, num1, num2);
                break;
            default:
                throw new OperationNotSupportException("..............Such operation not exist.............");
        }
        if (Objects.nonNull(response)) {
            boolean result = saveOperation(response);
            if (result) {
                return response;
            } else throw new OperationNotSupportException("any problems with databases");
        } else throw new OperationNotSupportException("response is null");
    }

    @Override
    public boolean saveOperation(MathResultInfo mathResultInfo) {
        MathResultInfo resultInfo = mathOperationRepository.save(response);
        if (Objects.nonNull(resultInfo))
            return true;
        else return false;
    }
}


//package com.example.calculator.services;
//
//        import com.example.calculator.exception.OperationNotSupportException;
//        import com.example.calculator.configurations.ServiceAddressConfig;
//        import com.example.supportmodule.dto.DtoMathOperation;
//        import com.example.supportmodule.entities.MathResultInfo;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.stereotype.Service;
//        import org.springframework.web.client.RestTemplate;
//
//@Service
//public class CalculatorServiceImpl implements CalculatorService {
//
//    final RestTemplate template;
//
//    final ServiceAddressConfig serviceAddressConfig;
//
//    @Autowired
//    public CalculatorServiceImpl(RestTemplate template, ServiceAddressConfig serviceAddressConfig) {
//        this.template = template;
//        this.serviceAddressConfig = serviceAddressConfig;
//    }
//
//    @Override
//    public ResponseEntity<DtoMathOperation> calculate(String operation, int num1, int num2) {
//        switch (operation) {
//            case "add":
//                return new ResponseEntity<>(template.getForObject(
//                        serviceAddressConfig.getAddition(), DtoMathOperation.class, num1, num2), HttpStatus.OK);
//            case "div":
//                return new ResponseEntity<>(template.getForObject(
//                        serviceAddressConfig.getDivision(), DtoMathOperation.class, num1, num2), HttpStatus.OK);
//            case "mul":
//                return new ResponseEntity<>(template.getForObject(
//                        serviceAddressConfig.getMultiplication(), DtoMathOperation.class, num1, num2), HttpStatus.OK);
//            case "sub":
//                return new ResponseEntity<>(template.getForObject(
//                        serviceAddressConfig.getSubtraction(), DtoMathOperation.class, num1, num2), HttpStatus.OK);
//            default:
//                throw new OperationNotSupportException("..............Such operation not exist.............");
//        }
//    }
//}


//    static {
//        Iterable<MathResultInfo> allDataInDb = mathOperationRepository.findAll();
//        for (MathResultInfo mathResultInfo : allDataInDb) {
//            mathResultInfo
//        }
//    }