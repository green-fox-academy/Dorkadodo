package com.greenfoxacademy.backendapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private String endpoint;
    private String data;

    @Transient
    private Date date;

    public Log(){}

    public Log(String endpoint, String data){
        this.endpoint = endpoint;
        this.data = data;
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
