package com.greenfoxacademy.projectweekzero.model;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    @Column(nullable = false)
    private Integer id;
    @SerializedName("imdb_id")
    @Column(name = "imdb_id")
    private String imdbId;
    @SerializedName("original_title")
    @Column(name = "original_title")
    private String originalTitle;
    @Column(columnDefinition = "TEXT")
    private String overview;
    @SerializedName("release_date")
    @Column(name = "release_date")
    private String releaseDate;
    private Integer runtime;
    private String status;
    private String title;

    @ManyToMany
    @JoinTable(
            name="movie_genres",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = null;

    public Movie() {
    }

    public Movie(Integer id, String imdbId, String originalTitle, String overview, String releaseDate, Integer runtime, String status, String title, List<Genre> genres) {
        this.id = id;
        this.imdbId = imdbId;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.status = status;
        this.title = title;
        this.genres = genres;
    }

    //region GettersAndSetters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
    //endregion

}
