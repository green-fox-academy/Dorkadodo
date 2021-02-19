package com.greenfoxacademy.projectweekzero.service;

import com.greenfoxacademy.projectweekzero.controller.TheMovieDatabase;
import com.greenfoxacademy.projectweekzero.exception.InvalidMovieIdException;
import com.greenfoxacademy.projectweekzero.model.Movie;
import com.greenfoxacademy.projectweekzero.model.MovieListDTO;
import com.greenfoxacademy.projectweekzero.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
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

    private void getAllMoviesFromTMDb (Integer page) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(System.getenv("TMDB_URL"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TheMovieDatabase movieRequest = retrofit.create(TheMovieDatabase.class);
        Call<MovieListDTO> call = movieRequest.getAllMovie(page, System.getenv("API_KEY"));
        Response<MovieListDTO> movieResponse = call.execute();
        saveListToDatabase(movieResponse);
    }

    private void saveListToDatabase(Response<MovieListDTO> movieResponse) {
        movieRepository.deleteAll();
        try {
        movieResponse.body().getResults().forEach(movie -> movieRepository.save(movie));
        } catch (NullPointerException ex){
                    System.out.println("No popular movies found");
        }
    }

    public List<Movie> getAllMovies() throws IOException {
        return getAllMovies(1);
    }

    public List<Movie> getAllMovies(Integer page) throws IOException {
        getAllMoviesFromTMDb(page);
        return (List<Movie>) movieRepository.findAll();
    }
}
