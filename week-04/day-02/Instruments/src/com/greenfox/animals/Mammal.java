package com.greenfox.animals;

public class Mammal extends Animal{
    public Mammal(String name){
        super(name, "Mammal");
    }

    BreedingMethods method = new BreedingMethods();
    public String breed (){
        return method.viviparous();
    }
}
