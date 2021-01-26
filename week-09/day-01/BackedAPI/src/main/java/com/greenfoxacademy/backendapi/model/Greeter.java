package com.greenfoxacademy.backendapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeter {
    @JsonProperty(value = "welcome_message")
    private String welcomeMessage;

    public Greeter() {

    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcome_message(String name, String title) {
        this.welcomeMessage = "Oh, hi there " + name + ", my dear " + title + "!";
    }
}
