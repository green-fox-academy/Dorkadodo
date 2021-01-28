package com.greenfoxacademy.resttest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Ammunition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caliber;
    private String name;
    private Integer amount;
    @JsonIgnore
    @Transient
    private final Integer fullShipCapacity = 12500;

    public Ammunition() {
    }

    public Ammunition(String caliber) {
        this.caliber = caliber;
        name = "caliber" + caliber.substring(1);
        amount = 0;
    }

    //region GettersAndSetters
    public Integer getFullShipCapacity() {
        return fullShipCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    //endregion
}
