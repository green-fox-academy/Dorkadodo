package com.greenfoxacademy.programmerfoxclub.service;

import com.greenfoxacademy.programmerfoxclub.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AssetService {

    @Autowired
    FoxService foxService;

    Trick trick;

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

    public List<TrickType> tricksNotYetAdded(){
        List<TrickType> tricksNotYetAdded = Arrays.asList(TrickType.values()).stream()
                    .filter(trick -> !(foxService.getListOfTricksOfCurrentFox()
                            .stream()
                            .map(trick1 -> trick1.getName())
                            .collect(Collectors.toList())
                            .contains(trick)))
                    .collect(Collectors.toList());
        return tricksNotYetAdded;
    }

    public void addNewFoodForFox(String foodName) throws LoginUserException{
        foxService.getCurrentFox().addNewFood(FoodType.valueOf(foodName));
    }

    public void addNewDrinkForFox(String drinkName) throws LoginUserException{
        foxService.getCurrentFox().addNewDrink(DrinkType.valueOf(drinkName));
    }

    public void addNewTrickForFox(String trickName) throws LoginUserException{
        foxService.getCurrentFox().learnNewTrick(new Trick (getTrickTypeFromDescription(trickName)));
    }

    private TrickType getTrickTypeFromDescription (String description){
        trick = new Trick();
        Optional<TrickType> optionalTrick = Arrays.stream(TrickType.values())
                .filter(trick1 -> trick.describeTrick(trick1).equals(description))
                .findFirst();
        if(optionalTrick.isEmpty()){
            return null;
        }
        return optionalTrick.get();
    }

    private String getDescriptionFromTrickType (TrickType type){
        trick = new Trick();
        return trick.describeTrick(type);
    }

    public List<String> getDescriptionOfTricksNotYetAdded (){
        List<String> descriptionOfTricksNotYetAdded = tricksNotYetAdded().stream()
                .map(trickType -> getDescriptionFromTrickType(trickType))
                .collect(Collectors.toList());
        return descriptionOfTricksNotYetAdded;
    }

    public String getPicturePathFromColor (ColorType colorType){
        return getPaths().get(colorType);
    }

    private HashMap<ColorType, String> getPaths (){
        HashMap<ColorType, String> listOfPictures = new HashMap<>();
        listOfPictures.put(ColorType.GREEN, "/greenfox.png");
        listOfPictures.put(ColorType.BLUE, "/bluefox.png");
        listOfPictures.put(ColorType.PINK, "/pinkfox.png");
        listOfPictures.put(ColorType.YELLOW, "/yellowfox.png");
        return listOfPictures;
    }

    public List<String> costums (){
        List<String> costums = Arrays.stream(ColorType.values())
                .map(colorType -> colorType.toString())
                .collect(Collectors.toList());
        return costums;
    }

    public void changeColorOfFox (String color) throws LoginUserException{
        foxService.getCurrentFox().setColor(ColorType.valueOf(color));
    }
}
