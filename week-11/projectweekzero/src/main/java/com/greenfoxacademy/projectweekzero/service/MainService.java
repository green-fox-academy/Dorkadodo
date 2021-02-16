package com.greenfoxacademy.projectweekzero.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.projectweekzero.controller.TheMovieDatabase;
import com.greenfoxacademy.projectweekzero.model.Movie;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class MainService {

    public Movie getMovieById (Integer id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(System.getenv("TMDB_URL"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TheMovieDatabase movieRequest = retrofit.create(TheMovieDatabase.class);
        Call<Movie> call = movieRequest.getMovieById(id, System.getenv("API_KEY"));
        Movie movie = null;
        try {
            Response<Movie> responseMovie = call.execute();
            System.out.println(responseMovie);
            movie = responseMovie.body();
        } catch (IOException e) {
            System.out.println("error with retrofit call");
        }
        return movie;
    }
}
