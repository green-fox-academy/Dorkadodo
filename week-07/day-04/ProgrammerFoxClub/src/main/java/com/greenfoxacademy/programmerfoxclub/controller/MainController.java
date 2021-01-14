package com.greenfoxacademy.programmerfoxclub.controller;

import com.greenfoxacademy.programmerfoxclub.service.AssetService;
import com.greenfoxacademy.programmerfoxclub.service.FoxService;
import com.greenfoxacademy.programmerfoxclub.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    FoxService foxService;
    @Autowired
    LoginService loginService;
    @Autowired
    AssetService assetService;

    @GetMapping ("/")
    public String rootPath (){
        try{
            foxService.getCurrentFox().getName();
        } catch (NullPointerException ex){
            return "redirect:/login";
        }
        return "redirect:/information";
    }

    @GetMapping ("/information")
    public String homePage(Model model){
        try{
            foxService.getCurrentFox().getName();
        } catch (NullPointerException ex){
            return "redirect:/login";
        }
        model.addAllAttributes(foxService.getAttributesOfCurrentFox());
        return "index";
    }

    @GetMapping ("/login")
    public String loginPage (){
        return "login";
    }

    @PostMapping ("/login")
    public String loginData (@RequestParam String name, Model model){
        try {
            if(!(loginService.isNameValid(name))){
                return "redirect:/login";
            }
        }
        catch (NullPointerException ex){
            return "redirect:/login";
        }
        loginService.setCurrentFox(name);
        return "redirect:/information";
    }

    @GetMapping ("/nutrition-store")
    public String nutritionStore (Model model){
        try{
            foxService.getCurrentFox().getName();
        } catch (NullPointerException ex){
            return "redirect:/login";
        }
        model.addAttribute("listOfFood", assetService.foodsNotYetAdded());
        model.addAttribute("listOfDrink", assetService.drinksNotYetAdded());
        return "nutritionstore";
    }

    @PostMapping ("/nutrition-store/food")
    public String buyFood (String food){
        assetService.addNewFoodForFox(food);
        return "redirect:/nutrition-store";
    }

    @PostMapping ("/nutrition-store/drink")
    public String buyDrink (String drink){
        assetService.addNewDrinkForFox(drink);
        return "redirect:/nutrition-store";
    }

    @GetMapping ("/trick-center")
    public String trickCenter (Model model){
        try{
            foxService.getCurrentFox().getName();
        } catch (NullPointerException ex){
            return "redirect:/login";
        }
        model.addAttribute("listOfTricks", assetService.listOfTricks());
        return "trickcenter";
    }

    @PostMapping ("/trick-center/learn-trick")
    public String learnNewTrick (@RequestParam String trickName){
        assetService.addNewTrickForFox(trickName);
        return "redirect:/information";
    }

}
