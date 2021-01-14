package com.greenfoxacademy.programmerfoxclub.service;

import com.greenfoxacademy.programmerfoxclub.model.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoxService {
    private List<Fox> listOfFox;

    private static Fox currentFox;

    public FoxService (){
        listOfFox = new ArrayList<>();
        Fox fox = new Fox("Vuk");
        fox.addNewFood(FoodType.PIZZA);
        fox.addNewDrink(DrinkType.LEMONADE);
        listOfFox.add(fox);
        fox = new Fox("Karak");
        fox.addNewFood(FoodType.TOAST);
        fox.addNewDrink(DrinkType.BEER);
        listOfFox.add(fox);
    }

    public List<Fox> getListOfFox() {
        return listOfFox;
    }

    public List<String> getListOfNameOfFox(){
        List<String> namesOfFox = listOfFox.stream()
                .map(fox -> fox.getName())
                .collect(Collectors.toList());
        return namesOfFox;
    }

    public void addNewFox (Fox fox){
        listOfFox.add(fox);
    }

    public Fox getCurrentFox() {
        return currentFox;
    }

    public List<Trick> getListOfTricksOfCurrentFox (){
        return currentFox.getListOfTrick();
    }

    public List<String> getNameOfTricksOfCurrentFox (){
        List<String> nameOfTricks = currentFox.getListOfTrick().stream()
                .map(trick -> trick.describeTrick(TrickType.valueOf(trick.getName().toString())))
                .collect(Collectors.toList());
        return nameOfTricks;

    }

    public List<FoodType> getListOfFoodOfCurrentFox (){
        return currentFox.getListOfFood();
    }

    public List<String> getNameOfFoodOfCurrentFox (){
        List<String> nameOfFood = currentFox.getListOfFood().stream()
                .map(food -> food.toString().toLowerCase())
                .collect(Collectors.toList());
        return nameOfFood;
    }

    private String getStringOfFoodOfCurrentFox (){
        String namesOfFood = getNameOfFoodOfCurrentFox().stream()
                .map(food -> String.valueOf(food))
                .collect(Collectors.joining(", ", "", ""));
        return namesOfFood;
    }

    public List<DrinkType> getListOfDrinkOfCurrentFox (){
        return currentFox.getListOfDrink();
    }

    public List<String> getNameOfDrinkOfCurrentFox (){
        List<String> nameOfDrink = currentFox.getListOfDrink().stream()
                .map(drink -> drink.toString().toLowerCase())
                .collect(Collectors.toList());
        return nameOfDrink;
    }

    private String getStringOfDrinkOfCurrentFox (){
        String namesOfDrink = getNameOfDrinkOfCurrentFox().stream()
                .map(drink -> String.valueOf(drink))
                .collect(Collectors.joining(", ", "", ""));
        return namesOfDrink;
    }

    public HashMap<String, Object> getAttributesOfCurrentFox (){
        HashMap<String, Object> attributesOfCurrentFox = new HashMap<>();
        attributesOfCurrentFox.put("name", currentFox.getName());
        attributesOfCurrentFox.put("tricks", ((currentFox.getListOfTrick().size() == 0) ? "Sorry, he doesn't know any tricks yet" : getNameOfTricksOfCurrentFox()));
        attributesOfCurrentFox.put("food", getStringOfFoodOfCurrentFox());
        attributesOfCurrentFox.put("drink", getStringOfDrinkOfCurrentFox());
        attributesOfCurrentFox.put("numberOfTricks", currentFox.getListOfTrick().size());
        return attributesOfCurrentFox;
    }

    public void changeCurrentFox (String name){
        Optional<Fox> optionalFox = listOfFox.stream()
                .filter(fox -> fox.getName().equals(name))
                .findFirst();
        if (optionalFox.isEmpty()){
            return;
        }
        currentFox = optionalFox.get();
    }
}
