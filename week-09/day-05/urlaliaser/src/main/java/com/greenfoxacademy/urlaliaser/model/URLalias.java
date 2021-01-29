package com.greenfoxacademy.urlaliaser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class URLalias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String alias;
    private Integer hitCount;

    @JsonIgnore
    private String secretCode;

    public URLalias() {}

    public URLalias(String url, String alias) {
        this.url = url;
        this.alias = alias;
        secretCode = generateSecretCode();
        hitCount = 0;
    }

    private String generateSecretCode(){
        Random random = new Random();
        String secretCode = "";
        for (int i = 0; i < 4; i++) {
            secretCode += random.nextInt(10);
        }
        return secretCode;
    }

    //region GettersAndSetters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
    //endregion
}
