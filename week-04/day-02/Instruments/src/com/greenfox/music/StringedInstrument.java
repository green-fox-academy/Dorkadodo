package com.greenfox.music;

public abstract class StringedInstrument extends Instrument {
    protected int numberOfStrings;

    public StringedInstrument(int numberOfStrings, String name) {
        this.numberOfStrings = numberOfStrings;
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name + ", a " + numberOfStrings + "-stringed instrument that goes " + sound());
    }

    protected abstract String sound();
}
