package com.greenfox.animals;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String color;
    protected String type;

    public Animal (String name, String type){
        this.name=name;
        this.type=type;
    }

    public String getName (){
        return name;
    }

    public abstract String breed();

    public void eat (){
    }

    public void play (){
    }


}
