package com.greenfoxacademy.programmerfoxclub.service;

import com.greenfoxacademy.programmerfoxclub.model.DrinkType;
import com.greenfoxacademy.programmerfoxclub.model.FoodType;
import com.greenfoxacademy.programmerfoxclub.model.Trick;
import com.greenfoxacademy.programmerfoxclub.model.TrickType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AssetService {

    @Autowired
    FoxService foxService;

    public List<FoodType> listOfFood() {
        return Arrays.asList(FoodType.values());
    }

    public List<DrinkType> listOfDrink() {
        return Arrays.asList(DrinkType.values());
    }

    public List<String> listOfTricks() {
        Trick trick = new Trick();
        List<String> listOfTricks = Arrays.stream(TrickType.values())
                .map(trickType -> trick.describeTrick(trickType))
                .collect(Collectors.toList());
        return listOfTricks;
    }

    public List<FoodType> foodsNotYetAdded() {
        List<FoodType> foodsNotYetAdded = Arrays.asList(FoodType.values()).stream()
                .filter(food -> !(foxService.getListOfFoodOfCurrentFox().contains(food)))
                .collect(Collectors.toList());
        return foodsNotYetAdded;
    }

    public List<DrinkType> drinksNotYetAdded() {
        List<DrinkType> drinksNotYetAdded = Arrays.asList(DrinkType.values()).stream()
                .filter(drink -> !(foxService.getListOfDrinkOfCurrentFox().contains(drink)))
                .collect(Collectors.toList());
        return drinksNotYetAdded;
    }

    public void addNewFoodForFox(String foodName) {
        foxService.getCurrentFox().addNewFood(FoodType.valueOf(foodName));
    }

    public void addNewDrinkForFox(String drinkName) {
        foxService.getCurrentFox().addNewDrink(DrinkType.valueOf(drinkName));
    }

    public void addNewTrickForFox(String trickName) {
        Trick trick = new Trick();
        Optional<TrickType> optionalTrick = Arrays.stream(TrickType.values())
                .filter(trick1 -> trick.describeTrick(trick1).equals(trickName))
                .findFirst();
        if(optionalTrick.isEmpty()){
            return;
        }
        foxService.getCurrentFox().learnNewTrick(new Trick (optionalTrick.get()));
    }
}
