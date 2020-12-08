package com.greenfox.music;

public class ElectricGuitar extends StringedInstrument{

    public ElectricGuitar (){
        this (6);
    }

    public ElectricGuitar (int numberOfStrings){
        super(numberOfStrings, "Electric Guitar");
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    protected String sound() {
        return "Twang";
    }
}
