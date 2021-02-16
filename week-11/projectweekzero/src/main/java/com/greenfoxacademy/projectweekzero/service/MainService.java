package com.greenfoxacademy.projectweekzero.service;

import com.greenfoxacademy.projectweekzero.controller.TheMovieDatabase;
import com.greenfoxacademy.projectweekzero.exception.InvalidMovieIdException;
import com.greenfoxacademy.projectweekzero.model.Movie;
import com.greenfoxacademy.projectweekzero.model.MovieListDTO;
import com.greenfoxacademy.projectweekzero.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class MainService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovieById (Integer id) throws InvalidMovieIdException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(System.getenv("TMDB_URL"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TheMovieDatabase movieRequest = retrofit.create(TheMovieDatabase.class);

        Call<Movie> call = movieRequest.getMovieById(id, System.getenv("API_KEY"));
        Movie movie = null;
        try {
            movie = call.execute().body();
        } catch (IOException e) {
            throw new InvalidMovieIdException();
        }
        if (movie == null){
            throw new InvalidMovieIdException();
        }
        return movie;
    }

    private void getAllMoviesFromTMDb () throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(System.getenv("TMDB_URL"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TheMovieDatabase movieRequest = retrofit.create(TheMovieDatabase.class);
        Call<MovieListDTO> call = movieRequest.getAllMovie(System.getenv("API_KEY"));
        System.out.println(call);
        System.out.println(call.execute().body().getMovieList());
//        call.execute().body().getMovieList().stream()
//                .forEach(movie -> {movieRepository.save(movie);
//                    System.out.println(movie);});
    }

    public List<Movie> getAllMovies() throws IOException {
        getAllMoviesFromTMDb();
        return (List<Movie>) movieRepository.findAll();
    }
}
