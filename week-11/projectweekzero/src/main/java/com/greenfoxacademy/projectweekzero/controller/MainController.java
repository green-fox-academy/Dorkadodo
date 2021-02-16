package com.greenfoxacademy.projectweekzero.controller;

import com.greenfoxacademy.projectweekzero.exception.InvalidMovieIdException;
import com.greenfoxacademy.projectweekzero.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/get-movie/{movie_id}")
    public ResponseEntity<Object> getMovieById(@PathVariable ("movie_id") Integer movieId){
        try {
            return ResponseEntity.ok(mainService.getMovieById(movieId));
        } catch (InvalidMovieIdException e) {
            return new ResponseEntity<>(new Error("no movie with this id"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public String listAllMovies(Model model){
        try {
            model.addAttribute("movieList", mainService.getAllMovies());
        } catch (IOException e) {
            model.addAttribute("message", "Sorry, something went wrong with getting the list!");
        }
        return "index";
    }
}
