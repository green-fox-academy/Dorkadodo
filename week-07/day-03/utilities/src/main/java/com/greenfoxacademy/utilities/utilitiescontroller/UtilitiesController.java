package com.greenfoxacademy.utilities.utilitiescontroller;

import com.greenfoxacademy.utilities.serviceutilities.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilitiesController {

    @Autowired
    private UtilityService utilityService;

    @GetMapping("/useful")
    public String useful(){
        return "";
    }

    @GetMapping ("/useful/colored")
    public String colored (){

    }
}
