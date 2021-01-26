package com.greenfoxacademy.backendapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SithText {

    @JsonProperty(value = "sith_text")
    private String sithText;
    public SithText(String sithText){
        this.sithText = sithText;
    }

    public String getSithText() {
        return sithText;
    }

    public void setSithText(String sithText) {
        this.sithText = sithText;
    }
}
