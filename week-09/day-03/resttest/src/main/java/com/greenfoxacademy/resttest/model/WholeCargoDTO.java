package com.greenfoxacademy.resttest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenfoxacademy.resttest.repo.AmmunitionRepository;
import com.greenfoxacademy.resttest.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;

public class WholeCargoDTO {
    private Integer caliber25;
    private Integer caliber30;
    private Integer caliber50;
    private String shipstatus;
    private Boolean ready;

    public WholeCargoDTO() {
    }

    public WholeCargoDTO(Integer caliber25, Integer caliber30, Integer caliber50, String shipstatus, Boolean ready) {
        this.caliber25 = caliber25;
        this.caliber30 = caliber30;
        this.caliber50 = caliber50;
        this.shipstatus = shipstatus;
        this.ready = ready;
    }

    //region GettersAndSetters
    public Integer getCaliber25() {
        return caliber25;
    }

    public void setCaliber25(Integer caliber25) {
        this.caliber25 = caliber25;
    }

    public Integer getCaliber30() {
        return caliber30;
    }

    public void setCaliber30(Integer caliber30) {
        this.caliber30 = caliber30;
    }

    public Integer getCaliber50() {
        return caliber50;
    }

    public void setCaliber50(Integer caliber50) {
        this.caliber50 = caliber50;
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
