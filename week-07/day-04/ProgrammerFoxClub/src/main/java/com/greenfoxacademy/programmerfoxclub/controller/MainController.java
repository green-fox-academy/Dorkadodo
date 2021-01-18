package com.greenfoxacademy.programmerfoxclub.controller;

import com.greenfoxacademy.programmerfoxclub.service.AssetService;
import com.greenfoxacademy.programmerfoxclub.service.FoxService;
import com.greenfoxacademy.programmerfoxclub.service.LoginService;
import com.greenfoxacademy.programmerfoxclub.service.LoginUserException;
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
    public String rootPath()throws LoginUserException {
        loginService.isUserValid();

        return "redirect:/information";
    }

    @GetMapping ("/information")
    public String homePage(Model model)throws LoginUserException {
        loginService.isUserValid();
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
    public String nutritionStore (Model model) throws LoginUserException{
        loginService.isUserValid();
        if (assetService.foodsNotYetAdded().isEmpty() && assetService.drinksNotYetAdded().isEmpty()){
            model.addAttribute("message", "Sorry, we are out of nutrition!");
            return "message";
        }
        model.addAttribute("listOfFood", assetService.foodsNotYetAdded());
        model.addAttribute("listOfDrink", assetService.drinksNotYetAdded());
        return "nutritionstore";
    }

    @PostMapping ("/nutrition-store/food")
    public String buyFood (String food) throws LoginUserException{
        assetService.addNewFoodForFox(food);
        return "redirect:/nutrition-store";
    }

    @PostMapping ("/nutrition-store/drink")
    public String buyDrink (String drink) throws LoginUserException{
        assetService.addNewDrinkForFox(drink);
        return "redirect:/nutrition-store";
    }

    @GetMapping ("/trick-center")
    public String trickCenter (Model model) throws LoginUserException{
        loginService.isUserValid();
        if (assetService.getDescriptionOfTricksNotYetAdded().isEmpty()){
            model.addAttribute("message", "Congratulation, there are no more tricks to learn!");
            return "message";
        }
        model.addAttribute("listOfTricks", assetService.getDescriptionOfTricksNotYetAdded());
        return "trickcenter";
    }

    @PostMapping ("/trick-center/learn-trick")
    public String learnNewTrick (@RequestParam String trickName) throws LoginUserException{
        assetService.addNewTrickForFox(trickName);
        return "redirect:/information";
    }

    @GetMapping ("/costum-change")
    public  String getNewCostum (Model model){
        model.addAttribute("listOfColors", assetService.costums());
        return "costumChange";
    }

    @PostMapping ("/costum-change")
    public String changeCostum(String costum) throws LoginUserException{
        assetService.changeColorOfFox(costum);
        return "redirect:/information";
    }
}
