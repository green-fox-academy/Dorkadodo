package com.greenfoxacademy.reddit.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer voteCount;
    private Date dateOfCreation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name="label_tagged",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<Label> addedLabels;

    @Transient
    private Date date;

    public Post(){
        this.voteCount = 0;
        this.dateOfCreation = new Date();
    }

    public Set<Label> getAddedLabels() {
        return addedLabels;
    }

    public void setAddedLabels(Set<Label> addedLabels) {
        this.addedLabels = addedLabels;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDateOfCreation() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return formatter.format(dateOfCreation);
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDescription(){
        if (!(description == null)) {
            description = description.replaceAll("(\r\n)", "<br>");
        }
        return description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
