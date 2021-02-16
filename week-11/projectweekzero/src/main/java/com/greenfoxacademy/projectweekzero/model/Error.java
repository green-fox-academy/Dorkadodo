package com.greenfoxacademy.projectweekzero.model;

public class Error {
    private String messsage;

    public Error (String message){
        this.messsage = message;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
