package com.greenfoxacademy.springstart.controllers;

public class Greeting {
    Long id;
    String content;

    public Greeting (Long id, String content){
        this.id=id;
        this.content="Hello, " + content + "!";
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
