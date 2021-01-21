package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedditController {

    @Autowired
    private PostService postService;

    @GetMapping ("/")
    public String root (){
        return "redirect:/reddit";
    }

    @GetMapping ("/reddit")
    public String homePage (Model model){
        model.addAttribute("postList", postService.getPosts());
        return "index";
    }

    @GetMapping ("/reddit/new-post")
    public String writeNewPost (){
        return "newPost";
    }

    @PostMapping ("/reddit/new-post")
    public String submitNewPost (@ModelAttribute Post post){
        postService.addNewPost(post);
        return "redirect:/reddit";
    }
}
