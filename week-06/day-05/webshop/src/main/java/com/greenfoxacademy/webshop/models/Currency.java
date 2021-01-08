package com.greenfoxacademy.webshop.models;

import java.util.List;

public class Currency {
    private String name;
    private String sign;
    private double exchangeRate;

    public Currency(String name, String sign, double exchangeRate) {
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
