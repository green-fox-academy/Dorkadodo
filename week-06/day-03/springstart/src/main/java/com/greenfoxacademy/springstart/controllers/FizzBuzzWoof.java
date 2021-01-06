package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class FizzBuzzWoof {
    AtomicLong atomicLong = new AtomicLong();

    @RequestMapping("/web/fizzbuzzwoof")
    public String greeting(Model model) {
        Long counter = atomicLong.getWebCounter();
        String counterString = "";
        int keywords = 0;

        if (counter % 3 == 0) {
            counterString += "Fizz";
            keywords++;
        }
        if (counter % 5 == 0) {
            counterString += "Buzz";
            keywords++;
        }
        if (counter % 7 == 0) {
            counterString += "Woof";
            keywords++;
        }
        if (counterString.equals("")) {
            counterString = String.valueOf(counter);
        }

        String fontsize = String.valueOf(12 * keywords + 12);

        model.addAttribute("counter", counterString);
        model.addAttribute("fontsize", fontsize);

        return "fizzbuzzwoof";
    }
}
