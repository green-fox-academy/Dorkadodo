package com.greenfoxacademy.webshop.models;

public class ShopItem {

    private String name;
    private String description;
    private Long price;
    private Integer quantityOfStock;

    public ShopItem(String name, String description, Long price, Integer quantityOfStock) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantityOfStock() {
        return quantityOfStock;
    }
}
