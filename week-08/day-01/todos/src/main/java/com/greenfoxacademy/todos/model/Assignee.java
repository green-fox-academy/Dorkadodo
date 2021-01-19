package com.greenfoxacademy.todos.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Assignee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany (mappedBy = "assignee")
    private List<Todo> todoList;

    public Assignee() {
        todoList = new ArrayList<>();
    }
    public Assignee(String name, String email){
        todoList = new ArrayList<>();
        this.name = name;
        this.email = email;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
