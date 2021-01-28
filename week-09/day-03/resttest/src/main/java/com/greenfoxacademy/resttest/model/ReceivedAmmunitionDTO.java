package com.greenfoxacademy.resttest.model;

public class ReceivedAmmunitionDTO {
    private String received;
    private Integer amount;
    private String shipstatus;
    private Boolean ready;

    public ReceivedAmmunitionDTO(String received, Integer amount, String shipstatus, Boolean ready) {
        this.received = received;
        this.amount = amount;
        this.shipstatus = shipstatus;
        this.ready = ready;
    }

    //region GettersAndSetters
    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getShipstatus() {
        return shipstatus;
    }

    public void setShipstatus(String shipstatus) {
        this.shipstatus = shipstatus;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }
    //endregion
}
