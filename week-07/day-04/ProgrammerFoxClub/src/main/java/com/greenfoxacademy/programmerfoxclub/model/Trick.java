package com.greenfoxacademy.programmerfoxclub.model;

public class Trick {
    private TrickType name;

    public TrickType getName() {
        return name;
    }

    public Trick (TrickType tpye){
        name = tpye;
    }

    public Trick (){}

    public String describeTrick(TrickType trick){
        switch (trick) {
            case HTML:{
                return writeHtml();
            }
            case JAVA:{
                return codeJava();
            }
            default:{
                return "Sorry, can't do any tricks.";
            }
        }
    }
     private String writeHtml (){
        return "writing HTML";
     }
     private String codeJava(){
        return "coding Java";
     }

}
