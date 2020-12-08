package com.greenfox.interfaceExcercises;

public class Helicopter extends Vehicle implements  Flyable{

    @Override
    public void land() {
        System.out.println(name + " is landing.");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }

    @Override
    public void takeOff() {
        System.out.println(name + " is taking off.");
    }
}
