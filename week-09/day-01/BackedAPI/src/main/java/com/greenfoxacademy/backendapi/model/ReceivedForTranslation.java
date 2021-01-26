package com.greenfoxacademy.backendapi.model;

public class ReceivedForTranslation {
    private String text;
    private String lang;

    public ReceivedForTranslation() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
