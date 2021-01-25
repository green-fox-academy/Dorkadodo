package com.greenfoxacademy.backendapi.model;

public class Append {
    private String appended;

    public Append(String appendable) {
        this.appended = appendable + "a";
    }

    public void setAppended(String appended) {
        this.appended = appended;
    }

    public String getAppended() {
        return appended;
    }
}
