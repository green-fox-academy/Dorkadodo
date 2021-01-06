package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWebController {

    AtomicLongWeb atomicLongWeb = new AtomicLongWeb();

    @RequestMapping("/web/greeting")
    public String greeting(Model model, @RequestParam String name) {
        Long counter = atomicLongWeb.getCounter();
        model.addAttribute("name", name);
        model.addAttribute("counter", counter);
        return "greeting";
    }
}
