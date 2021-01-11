package com.greenfoxacademy.webshop.models;

import java.util.concurrent.atomic.AtomicLong;

public class ShopItem {

    private Long ID;
    private String name;
    private String description;
    private Long price;
    private Integer quantityOfStock;
    private Integer amountToBuy;

    AtomicLong atomicLong = new AtomicLong(1);

    public ShopItem(String name, String description, Long price, Integer quantityOfStock) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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

    public void setAmountToBuy(Integer amountToBuy) {
        this.amountToBuy = amountToBuy;
    }
}
