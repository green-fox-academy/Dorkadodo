package com.greenfoxacademy.reddit.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany (mappedBy = "user")
    private List<Post> listOfPostsOfUser;

    public User(){
        listOfPostsOfUser = new ArrayList<>();
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
        listOfPostsOfUser = new ArrayList<>();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getListOfPostsOfUser() {
        return listOfPostsOfUser;
    }

    public void setListOfPostsOfUser(List<Post> listOfPostsOfUser) {
        this.listOfPostsOfUser = listOfPostsOfUser;
    }
}
