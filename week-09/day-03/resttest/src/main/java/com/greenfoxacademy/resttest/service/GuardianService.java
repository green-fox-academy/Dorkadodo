package com.greenfoxacademy.resttest.service;

import com.greenfoxacademy.resttest.model.ErrorMessage;
import com.greenfoxacademy.resttest.model.GrootTranslator;
import org.springframework.stereotype.Service;

@Service
public class GuardianService {
    public GrootTranslator translateToGroot(String message){
        return new GrootTranslator(message);
    }

    public ErrorMessage error(){
        return new ErrorMessage("I am ErrorMessage Groot!");
    }
}
