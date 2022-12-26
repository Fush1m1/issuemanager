package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PositionNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PositionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String PositionNotFoundHandler(PositionNotFoundException ex) {
        return ex.getMessage();
    }
}
