package com.greenfoxacademy.programmerfoxclub.model;

import java.util.ArrayList;
import java.util.List;

public class Fox {
    private String name;
    private List<Trick> listOfTrick;
    private List<FoodType> listOfFood;
    private List<DrinkType> listOfDrink;
    private ColorType color;



    public Fox(String name) {
        this.name = name;
        listOfTrick = new ArrayList<>();
        listOfFood = new ArrayList<>();
        listOfDrink = new ArrayList<>();
        color = ColorType.GREEN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public List<Trick> getListOfTrick() {
        return listOfTrick;
    }

    public List<FoodType> getListOfFood() {
        return listOfFood;
    }

    public List<DrinkType> getListOfDrink() {
        return listOfDrink;
    }

    public void learnNewTrick (Trick trick){
        listOfTrick.add(trick);
    }

    public void addNewFood (FoodType food){
        listOfFood.add(food);
    }

    public void addNewDrink (DrinkType drink){
        listOfDrink.add(drink);
    }
}
