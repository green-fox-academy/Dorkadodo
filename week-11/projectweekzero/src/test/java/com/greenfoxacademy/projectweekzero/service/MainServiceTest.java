package com.greenfoxacademy.projectweekzero.service;

import com.greenfoxacademy.projectweekzero.exception.InvalidMovieIdException;
import com.greenfoxacademy.projectweekzero.model.Episode;
import com.greenfoxacademy.projectweekzero.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class MainServiceTest {

    MainService mainService;
    @BeforeEach
    public void autowiredMainService(){
        mainService = new MainService();
    }

//    @Test
//    public void testtest (){
//        assertEquals(1, 1);
//    }

    @Test
    public void getMovieById() throws InvalidMovieIdException {
        Integer id = 5;
        Movie mockMovie = new Movie(5, "tt0113101", "Four Rooms",
                "It's Ted the Bellhop's first night on the job...and the hotel's very unusual guests are about to place him in some outrageous predicaments. " +
                        "It seems that this evening's room service is serving up one unbelievable happening after another.",
                "1995-12-09", 98, "Released", "Four Rooms");
        Movie newMovie = mainService.getMovieById(id);
//        assertEquals(newMovie.getId(), mockMovie.getId());
//        assertEquals(newMovie.getTitle(), mockMovie.getTitle());
        assertEquals(newMovie, mockMovie);
    }

    @Test
    public void getAllMovies() throws IOException {
        Integer seriesId = 5;
        Integer season = 1;
        List<Episode> mockList = Arrays.asList(new Episode ("2006-10-23", 6, 1130498, "Quitte ou double","","",1),
                new Episode ("2006-10-30",7, 1130499,"Bienvenue, Terrebonne!","","",1),
                new Episode ("2006-11-06",10, 1130500,"Les trois B","","",1),
                new Episode ("2006-10-09",1, 1130502,"Dégraissage","","",1),
                new Episode ("2006-10-09",2,1130503,"Image de marque","","",1),
                new Episode ("2006-10-09", 4,1130504,"Conscientisation","","",1),
                new Episode ("2006-10-23",5,1130505,"Secrétaire personnelle","","",1),
                new Episode ("2006-10-16",3,1130506,"Questions/réponses","","",1),
                new Episode ("2006-11-13",11,1130507,"C't'encore drôle!","","",1),
                new Episode ("2006-11-13",12,1130508,"Solde avant liquidation","","",1),
                new Episode ("2006-11-06",9,1130509,"Vibrations","","",1),
                new Episode ("2006-10-30", 8,1130510,"Sortie de secours","","",1));
        List<Episode> newList = mainService.getAllMoviesFromTMDb(seriesId, season);
        assertArrayEquals(mockList.toArray(), newList.toArray());

    }
//
//    @Test
//    public void testGetAllMovies() {
//    }
}