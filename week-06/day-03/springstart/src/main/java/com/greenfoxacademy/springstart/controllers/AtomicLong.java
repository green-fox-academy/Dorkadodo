package com.greenfoxacademy.springstart.controllers;

public class AtomicLong {
    private Long counter=0L;
    private Long webCounter=0L;

    public Long getCounter (){
        counter++;
        return counter;
    }

    public Long getWebCounter (){
        webCounter++;
        return webCounter;
    }
}
