package com.greenfox.interfaceExcercises;

public class Domino implements Printable{
    private int rightField;
    private int leftField;

    public void setRightField(int rightField) {
        this.rightField = rightField;
    }

    public void setLeftField(int leftField) {
        this.leftField = leftField;
    }

    public int getRightField() {
        return rightField;
    }

    public int getLeftField() {
        return leftField;
    }

    @Override
    public void printAllFields() {
        System.out.println("Domino A side: " + rightField + ", B side: " + leftField);
    }
}
