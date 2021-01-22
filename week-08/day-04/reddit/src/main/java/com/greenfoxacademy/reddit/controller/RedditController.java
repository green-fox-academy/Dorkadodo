package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.model.Label;
import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.model.User;
import com.greenfoxacademy.reddit.service.LabelService;
import com.greenfoxacademy.reddit.service.PostService;
import com.greenfoxacademy.reddit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RedditController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private LabelService labelService;

    @GetMapping("/")
    public String root() {
        return "redirect:/reddit";
    }

    @GetMapping("/reddit")
    public String homePage(@RequestParam(required = false, defaultValue = "1") String page, @RequestParam(required = false) String user, Model model) {
        model.addAttribute("pages", postService.getPageNumbers(page));
        model.addAttribute("currentPageNumber", page);
        model.addAttribute("postList", postService.getPosts(page));
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/reddit/new-post")
    public String writeNewPost(@RequestParam(required = false) String user, Model model) {
        if (user == null){
            return "login";
        }
        model.addAttribute("userName", user);
        return "newPost";
    }

    @PostMapping("/reddit/new-post")
    public String submitNewPost(@ModelAttribute Post post, @RequestParam (required = false) String userName) {
        if (userName == null){
            return "login";
        }
        postService.addUserToPost(post, userName);
        postService.addNewPost(post);
        return "redirect:/reddit?user=" + userName;
    }

    @GetMapping("/reddit/read-post/{id}")
    public String readPost(@PathVariable Long id, @RequestParam (required = false) String user, Model model) {
        Post postToRead = postService.getPostById(id);
        if (postToRead == null) {
            if (user == null) {
                return "redirect:/reddit";
            }
            return "redirect:/reddit?user=" + user;
        }
        model.addAttribute("post", postToRead);
        model.addAttribute("user", user);

        model.addAttribute("assignedLabeLList", postService.getAssignedLabelsByPostId(id));
        model.addAttribute("labelList", labelService.getNotAssignedLabels(id));

        User author = postToRead.getUser();
        if (author == null){
            return "readPost";
        }
        model.addAttribute("author", author.getUsername());
        return "readPost";
    }

    @GetMapping("/reddit/upvote/{id}")
    public String upvotePost(@PathVariable Long id, @RequestParam String page, @RequestParam (required = false) String user) {
        if (user == null){
            return "redirect:/reddit/login";
        }
        postService.upvotePost(id);
        return "redirect:/reddit?page=" + page + "&user=" + user;
    }

    @GetMapping("/reddit/downvote/{id}")
    public String downvotePost(@PathVariable Long id, @RequestParam String page, @RequestParam (required = false) String user) {
        if (user == null){
            return "redirect:/reddit/login";
        }
        postService.downvotePost(id);
        return "redirect:/reddit?page=" + page + "&user=" + user;
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
            return "redirect:/reddit?user=" + username;
        }
        model.addAttribute("message", loginMessage);
        return "login";
    }

    @GetMapping("/reddit/logout")
    public String logout(@RequestParam String user) {
        userService.logoutUser(user);
        return "redirect:/reddit";
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

    @PostMapping("/reddit/add-label/{id}")
    public String addNewLabelToPost(@PathVariable Long id, @RequestParam (required = false) String user, String newLabel){
        if(user == null){
            return "redirect:/reddit/login";
        }
        postService.addLabelToPost(id, newLabel);
        return "redirect:/reddit/read-post/" + id + "?user=" + user;
    }

}
