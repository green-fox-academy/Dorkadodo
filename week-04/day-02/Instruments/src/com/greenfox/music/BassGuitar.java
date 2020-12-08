package com.greenfox.music;

public class BassGuitar extends StringedInstrument{
    public BassGuitar (){
        this (4);
    }

    public BassGuitar (int numberOfStrings){
        super(numberOfStrings, "Bass Guitar");
        this.numberOfStrings = numberOfStrings;
    }


    @Override
    protected String sound() {
        return "Duum-duum-duum";
    }
}
