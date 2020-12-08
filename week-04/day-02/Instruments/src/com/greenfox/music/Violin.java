package com.greenfox.music;

public class Violin extends StringedInstrument {

    public Violin (){
        this (4);
    }

    public Violin (int numberOfStrings){
        super(numberOfStrings, "Violin");
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    protected String sound() {
        return "Screech";
    }
}
