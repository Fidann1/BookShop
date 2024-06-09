package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex){
        List<String> errors=new ArrayList<>();
        ex.getAllErrors().forEach(error->errors.add(error.getDefaultMessage()));
        Map<String,Object> result=new HashMap<>();

        result.put("errors",errors);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);






    }


}
