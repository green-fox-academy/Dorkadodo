package com.greenfoxacademy.backendapi.model;

import java.util.Arrays;

public class ChangedArrayResult {
    private Integer [] result;

    public ChangedArrayResult() {
    }

    public ChangedArrayResult(Integer [] result) {
        this.result = result;
    }

    public Integer [] getResult() {
        return result;
    }

    public void setResult(Integer [] result) {
        this.result = result;
    }
}
