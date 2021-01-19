package com.greenfoxacademy.todos.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean urgent;
    private Boolean done;
    private LocalDate dateOfCreation;

    @ManyToOne
    @JoinColumn (name = "assignee_id")
    private Assignee assignee;

    Timestamp timestamp;

    public Todo() {
        this.urgent = false;
        this.done = false;
        timestamp = new Timestamp(System.currentTimeMillis());
        this.dateOfCreation = timestamp.toLocalDateTime().toLocalDate();
    }
    public Todo(String title) {
        this.title = title;
        this.urgent = false;
        this.done = false;
        timestamp = new Timestamp(System.currentTimeMillis());
        this.dateOfCreation = timestamp.toLocalDateTime().toLocalDate();
    }
    public Todo(String title, Boolean urgent, Boolean done) {
        this.title = title;
        this.urgent = urgent;
        this.done = done;
        timestamp = new Timestamp(System.currentTimeMillis());
        this.dateOfCreation = timestamp.toLocalDateTime().toLocalDate();
    }


    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getUrgent() {
        return urgent;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setUrgent(Boolean urgent) {
        this.urgent = urgent;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
