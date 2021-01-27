package com.greenfoxacademy.backendapi.model;

public class ChangedValue {
    private Integer received;
    private Integer result;

    public ChangedValue() {
    }

    public ChangedValue(Integer received, Integer result) {
        this.received = received;
        this.result = result;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
