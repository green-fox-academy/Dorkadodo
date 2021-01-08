package com.greenfoxacademy.webshop.models;

public class ShopItem {

    private String name;
    private String description;
    private Integer price;
    private Integer quantityOfStock;

    public ShopItem(String name, String description, int price, int quantityOfStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityOfStock = quantityOfStock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantityOfStock() {
        return quantityOfStock;
    }
}
