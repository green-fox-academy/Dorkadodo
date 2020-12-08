package com.greenfox.animals;

import com.greenfox.interfaceExcercises.Flyable;

public class Bird extends Animal implements Flyable {
    public Bird(String name) {
        super(name, "Bird");
    }

    BreedingMethods method = new BreedingMethods();

    public String breed() {
        return method.layingEggs();
    }

    @Override
    public void land() {
        System.out.println("Bird is resting.");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flapping wings and flying.");
    }

    @Override
    public void takeOff() {
        System.out.println("Bird is taking off.");
    }
}
