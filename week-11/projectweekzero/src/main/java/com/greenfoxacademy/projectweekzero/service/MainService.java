package com.greenfoxacademy.projectweekzero.service;

import com.greenfoxacademy.projectweekzero.controller.TheMovieDatabase;
import com.greenfoxacademy.projectweekzero.exception.InvalidMovieIdException;
import com.greenfoxacademy.projectweekzero.model.Episode;
import com.greenfoxacademy.projectweekzero.model.Movie;
import com.greenfoxacademy.projectweekzero.model.EpisodeListDTO;
import com.greenfoxacademy.projectweekzero.repo.EpisodeRepository;
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
    @Autowired
    private EpisodeRepository episodeRepository;


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

    public List<Episode> getAllMoviesFromTMDb (Integer seriesId, Integer season) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(System.getenv("TMDB_URL"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TheMovieDatabase movieRequest = retrofit.create(TheMovieDatabase.class);
        Call<EpisodeListDTO> call = movieRequest.getAllMovie(seriesId, season, System.getenv("API_KEY"));
        System.out.println(call);
        Response<EpisodeListDTO> movieResponse = call.execute();
        List<Episode> episodeList = movieResponse.body().getEpisodes();
        saveListToDatabase(episodeList);
        return episodeList;
    }

    private void saveListToDatabase(List<Episode> episodeList) {
        try {
            episodeList.forEach(episode -> episodeRepository.save(episode));
        } catch (NullPointerException ex){
                    System.out.println("No popular movies found");
        }
    }

    public List<Episode> getAllMovies(Integer seriesId, Integer season) throws IOException {
        getAllMoviesFromTMDb(seriesId, season);
        return (List<Episode>) episodeRepository.findAll();
    }
}
