package com.greenfoxacademy.programmerfoxclub.service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandling{

    @ExceptionHandler (LoginUserException.class)
    public String loginExceptionHandling (){
        return "forward:/login";
    }
}
