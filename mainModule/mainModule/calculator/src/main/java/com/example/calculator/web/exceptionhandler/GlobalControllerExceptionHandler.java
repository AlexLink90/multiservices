package com.example.calculator.web.exceptionhandler;

import com.example.calculator.exception.OperationNotSupportException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> notFoundOperation(OperationNotSupportException ex){
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage()
        );
        return buildError(error);
    }

    private ResponseEntity<ErrorResponse> buildError(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.valueOf(error.getStatus()));
    }
}
