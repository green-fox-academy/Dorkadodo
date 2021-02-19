package com.greenfoxacademy.projectweekzero.service;

import com.greenfoxacademy.projectweekzero.ProjectweekzeroApplication;
import com.greenfoxacademy.projectweekzero.exception.InvalidMovieIdException;
import com.greenfoxacademy.projectweekzero.model.Genre;
import com.greenfoxacademy.projectweekzero.model.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class MainServiceTest {

    MainService mainService;

//    @Test
//    public void testtest (){
//        assertEquals(1, 1);
//    }

    @Test
    public void getMovieById() throws InvalidMovieIdException {
        mainService = new MainService();
        Integer id = 5;

        List<Genre> genres = Arrays.asList(new Genre(80, "Crime"), new Genre(35, "Comedy"));
        Movie mockMovie = new Movie(5, "tt0113101", "Four Rooms",
                "It's Ted the Bellhop's first night on the job...and the hotel's very unusual guests are about to place him in some outrageous predicaments. " +
                        "It seems that this evening's room service is serving up one unbelievable happening after another.",
                "1995-12-09", 98, "Released", "Four Rooms", genres);
        Movie newMovie = mainService.getMovieById(id);
        assertEquals(newMovie.getId(), mockMovie.getId());
        assertEquals(newMovie.getTitle(), mockMovie.getTitle());
    }

//    @Test
//    public void getAllMovies() {
//    }
//
//    @Test
//    public void testGetAllMovies() {
//    }
}