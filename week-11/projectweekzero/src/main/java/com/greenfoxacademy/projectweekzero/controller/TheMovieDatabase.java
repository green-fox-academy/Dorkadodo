package com.greenfoxacademy.projectweekzero.controller;

import com.greenfoxacademy.projectweekzero.model.Movie;
import com.greenfoxacademy.projectweekzero.model.EpisodeListDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheMovieDatabase {

    @GET("/3/movie/{movie_id}")
    Call<Movie> getMovieById (@Path("movie_id") Integer movieId, @Query("api_key") String apiKey);

    @GET("/3/tv/{tv_id}/season/{season_number}")
    Call<EpisodeListDTO> getAllMovie (@Path("tv_id") Integer seriesId, @Path("season_number") Integer season, @Query("api_key") String apiKey);
}
