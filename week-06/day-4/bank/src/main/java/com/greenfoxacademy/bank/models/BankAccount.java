package com.greenfoxacademy.bank.models;

import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {
    private Long id;
    private String name;
    private Integer balance;
    private String animalType;
    private Boolean isKing;
    private Boolean isGoodGuy;

    private static AtomicLong atomicLong = new AtomicLong(1);

    public BankAccount(String name, Integer balance, String animalType, Boolean isKing, Boolean isGoodGuy) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.isKing = isKing;
        this.isGoodGuy = isGoodGuy;
        id = atomicLong.getAndIncrement();
    }

    public String getName() {
        return name;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Boolean getGoodGuy() {
        return isGoodGuy;
    }

    public Boolean getKing() {
        return isKing;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setKing(Boolean king) {
        isKing = king;
    }

    public void setGoodGuy(Boolean goodGuy) {
        isGoodGuy = goodGuy;
    }

    public static void setAtomicLong(AtomicLong atomicLong) {
        BankAccount.atomicLong = atomicLong;
    }
}
