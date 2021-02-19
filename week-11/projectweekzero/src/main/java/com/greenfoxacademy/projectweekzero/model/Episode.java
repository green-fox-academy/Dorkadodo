package com.greenfoxacademy.projectweekzero.model;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Episode {

    @SerializedName(value = "air_date")
    private String airDate;
    @SerializedName(value = "episode_number")
    private Integer episodeNumber;
    @Id
    private Integer id;
    private String name;
    private String overview;
    @SerializedName(value = "production_code")
    private String productionCode;
    @SerializedName(value = "season_number")
    private Integer seasonNumber;

    public Episode() {
    }

    public Episode(String airDate, Integer episodeNumber, Integer id, String name, String overview, String productionCode, Integer seasonNumber) {
        this.airDate = airDate;
        this.episodeNumber = episodeNumber;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.productionCode = productionCode;
        this.seasonNumber = seasonNumber;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getProductionCode() {
        return productionCode;
    }

    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Episode)) return false;
        Episode episode = (Episode) o;
        return Objects.equals(getAirDate(), episode.getAirDate()) &&
                Objects.equals(getEpisodeNumber(), episode.getEpisodeNumber()) &&
                Objects.equals(getId(), episode.getId()) &&
                Objects.equals(getName(), episode.getName()) &&
                Objects.equals(getOverview(), episode.getOverview()) &&
                Objects.equals(getProductionCode(), episode.getProductionCode()) &&
                Objects.equals(getSeasonNumber(), episode.getSeasonNumber());
    }

}