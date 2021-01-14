package com.greenfoxacademy.programmerfoxclub.service;

import com.greenfoxacademy.programmerfoxclub.model.DrinkType;
import com.greenfoxacademy.programmerfoxclub.model.FoodType;
import com.greenfoxacademy.programmerfoxclub.model.Fox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    FoxService foxService;

    public Boolean isNameValid (String name) throws NullPointerException {
        if(name.equals("")){
            return false;
        }
        return true;
    }

    public Boolean doesFoxExist (String newName) {
        if (foxService.getListOfNameOfFox().contains(newName)){
            return true;
        }
        return false;
    }

    public Boolean isUserValid (String name) {
        try {
            if (!(isNameValid(name))) {
                return false;
            }
        } catch (NullPointerException ex){
            return false;
        }
        if (!(doesFoxExist(name))){
            return false;
        }
        return true;
    }

    public void setCurrentFox (String name){
        if (!(doesFoxExist(name))){
            Fox fox = new Fox(name);
            fox.addNewFood(FoodType.TOAST);
            fox.addNewDrink(DrinkType.LEMONADE);
            foxService.addNewFox(fox);
        }
        foxService.changeCurrentFox(name);
    }
}
