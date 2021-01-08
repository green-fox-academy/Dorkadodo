package com.greenfoxacademy.webshop.models;

public class Currency {
    private String name;
    private String sign;
    private Double exchangeRate;

    public Currency(String name, String sign, Double exchangeRate) {
        this.name = name;
        this.sign = sign;
        this.exchangeRate = exchangeRate;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
}
