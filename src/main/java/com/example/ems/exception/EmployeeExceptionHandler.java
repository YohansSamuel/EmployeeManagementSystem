package com.example.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
        EmployeeException employeeException = new EmployeeException(
                ex.getMessage(),ex.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(employeeException,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handleGlobalException(Exception e){
        EmployeeException employeeException = new EmployeeException(
                e.getMessage(),e.getCause(),HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(employeeException,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
