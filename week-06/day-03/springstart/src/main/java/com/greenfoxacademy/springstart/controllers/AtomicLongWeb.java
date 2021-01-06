package com.greenfoxacademy.springstart.controllers;

public class AtomicLongWeb {
    private Long counter=0L;

    public Long getCounter (){
        counter++;
        return counter;
    }
}
