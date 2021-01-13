package com.greenfoxacademy.utilities.utilitiescontroller;

import com.greenfoxacademy.utilities.serviceutilities.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UtilitiesController {

    @Autowired
    private UtilityService utilityService;

    @GetMapping("/useful")
    public String usefulGet(){
        return "index";
    }

    @PostMapping ("/useful/colored")
    public String colored (Model model){
        model.addAttribute("backgroundcolor", utilityService.randomColor());
        return "coloredPage";
    }

    @GetMapping ("/useful/email")
    public String email (@RequestParam String email, Model model){
        if (utilityService.validateEmail(email)){
            model.addAttribute("color", "green");
            model.addAttribute("message", email + " is a valid email address");
            return "emailValidation";
        }
        model.addAttribute("color", "red");
        model.addAttribute("message", email + " is not a valid email address");
        return "emailValidation";
    }

    @PostMapping ("/useful/caesar-encoder")
    public String caesarEncoder (String textToEncode, Integer numberForEncode, Model model){
        model.addAttribute("text", utilityService.caesar(textToEncode, numberForEncode));
        return "caesarText";
    }

    @PostMapping ("/useful/caesar-decoder")
    public String caesarDecoder (String textToDecode, Integer numberForDecode, Model model){
        model.addAttribute("text", utilityService.caesar(textToDecode, (-1)*(numberForDecode)));
        return "caesarText";
    }
}
