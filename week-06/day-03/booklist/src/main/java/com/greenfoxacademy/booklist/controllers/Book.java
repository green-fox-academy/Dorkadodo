package com.greenfoxacademy.booklist.controllers;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private Integer releaseYear;

    private static Integer nextId = 0;

    public Book (String title, String author, Integer releaseYear){
        this.title=title;
        this.author=author;
        this.releaseYear=releaseYear;
        nextId++;
        id=nextId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }
}
