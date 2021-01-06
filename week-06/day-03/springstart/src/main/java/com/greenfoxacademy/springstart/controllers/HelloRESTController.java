package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

    AtomicLong atomicLong = new AtomicLong();

    @RequestMapping (value = "/greeting")
    public Greeting greeting(@RequestParam String name){
        Long counter = atomicLong.getCounter();
        Greeting greeting = new Greeting(counter, name);
        return greeting;
    }
}
