package com.greenfox.animals;

public class Reptile extends Animal{
    public Reptile(String name){
        super(name, "Reptile");
    }

    BreedingMethods method = new BreedingMethods();
    public String breed (){
        return method.layingEggs();
    }
}
