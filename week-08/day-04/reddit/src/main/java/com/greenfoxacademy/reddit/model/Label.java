package com.greenfoxacademy.reddit.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Label {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String labelName;

    @ManyToMany(mappedBy = "addedLabels")
    private Set<Post> labelledPosts;

    public Label(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Set<Post> getLabelledPosts() {
        return labelledPosts;
    }

    public void setLabelledPosts(Set<Post> labelledPosts) {
        this.labelledPosts = labelledPosts;
    }
}
