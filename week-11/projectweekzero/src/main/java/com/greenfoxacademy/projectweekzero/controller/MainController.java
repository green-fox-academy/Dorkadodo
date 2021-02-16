package com.greenfoxacademy.projectweekzero.controller;

import com.greenfoxacademy.projectweekzero.model.Movie;
import com.greenfoxacademy.projectweekzero.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/get_movie")
    public ResponseEntity<Movie> getMovieById(){
        Movie movie = mainService.getMovieById(5);
        System.out.println(movie);
        return ResponseEntity.ok(movie);
    }
}
