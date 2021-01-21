package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.service.PostService;
import com.greenfoxacademy.reddit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RedditController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "redirect:/reddit";
    }

    @GetMapping("/reddit")
    public String homePage(@RequestParam(required = false, defaultValue = "1") String page, Model model) {
        model.addAttribute("pages", postService.getPages());
        model.addAttribute("postList", postService.getPosts(page));
        return "index";
    }

    @GetMapping("/reddit/new-post")
    public String writeNewPost() {
        return "newPost";
    }

    @PostMapping("/reddit/new-post")
    public String submitNewPost(@ModelAttribute Post post) {
        postService.addNewPost(post);
        return "redirect:/reddit";
    }

    @GetMapping("/reddit/read-post/{id}")
    public String readPost(@PathVariable Long id, Model model) {
        Post postToRead = postService.getPostById(id);
        if (postToRead == null) {
            return "redirect:/reddit";
        }
        model.addAttribute("post", postToRead);
        return "readPost";
    }

    @GetMapping("/reddit/upvote/{id}")
    public String upvotePost(@PathVariable Long id) {
        postService.upvotePost(id);
        return "redirect:/reddit";
    }

    @GetMapping("/reddit/downvote/{id}")
    public String downvotePost(@PathVariable Long id) {
        postService.downvotePost(id);
        return "redirect:/reddit";
    }

    @GetMapping("/reddit/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/reddit/login")
    public String login(@RequestParam String username, String password, Model model) {
        String loginMessage = userService.loginConfirmationMessage(username, password);
        if (loginMessage == null) {
            userService.loginUser(username);
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "redirect:/reddit";
        }
        model.addAttribute("message", loginMessage);
        return "login";
    }

    @GetMapping("/reddit/sign-up")
    public String signUpPage() {
        return "signUp";
    }

    @PostMapping("/reddit/sign-up")
    public String signUp(String username, String password, String confirmPassword, Model model) {
        String confirmMessage = userService.signUpConfirmationMessage(username, password, confirmPassword);
        if (confirmMessage == null) {
            userService.signUpUser(username, password);
            model.addAttribute("message", "Congratulations, you can login with your new credentials!");
            return "redirect:/reddit/login";
        }
        model.addAttribute("message", confirmMessage);
        return "signUp";
    }
}
