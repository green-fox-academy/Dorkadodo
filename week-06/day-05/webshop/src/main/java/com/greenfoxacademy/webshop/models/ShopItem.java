package com.greenfoxacademy.webshop.models;

import java.util.concurrent.atomic.AtomicLong;

public class ShopItem {

    private Long ID;
    private String name;
    private String description;
    private Double price;
    private Integer quantityOfStock;
    private Integer amountToBuy;

    private static AtomicLong atomicLong = new AtomicLong(1);

    public ShopItem(String name, String description, Double price, Integer quantityOfStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityOfStock = quantityOfStock;
        ID = atomicLong.getAndIncrement();
        amountToBuy = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityOfStock() {
        return quantityOfStock;
    }

    public Integer getAmountToBuy() {
        return amountToBuy;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantityOfStock(Integer quantityOfStock) {
        this.quantityOfStock = quantityOfStock;
    }

    public void setAmountToBuy(Integer amountToBuy) {
        this.amountToBuy = amountToBuy;
    }
}
