package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.User;
import com.greenfoxacademy.reddit.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private List<User> loggedInUsers;

    public UserService(){
        loggedInUsers = new ArrayList<>();
    }

    public User getUserByName (String userName){
        return userRepository.findUserByUsername(userName);
    }

    public String signUpConfirmationMessage (String username, String password, String passwordConfirmation){
        if (username == null || password == null || passwordConfirmation == null){
            return "Sorry, looks like some fields weren't correctly filled out!";
        }
        if (userExists(username)){
            return "Username already exists.";
        }
        if (!(password.equals(passwordConfirmation))){
            return "Password confirmation didn't work!";
        }
        if (!(isUsernameValid(username))){
            return "Username should only contain a-z, A-Z and 0-9!";
        }
        return null;
    }

    private Boolean isUsernameValid (String username){
        return username.matches("[a-zA-Z0-9]+");
    }

    public Boolean userExists (String username){
        Optional<User> optionalUser = ((List<User>)userRepository.findAll()).stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
        return optionalUser.isPresent();
    }

    public void signUpUser(String username, String password){
        userRepository.save(new User(username, password));
    }

    public String loginConfirmationMessage (String username, String password){
        if (!(userExists(username))){
            return "Username is wrong";
        }
        Optional<User> optionalUser = ((List<User>)userRepository.findAll()).stream()
                .filter(username1 -> username1.equals(username))
                .findFirst();
        if (optionalUser.isPresent()&&(!(optionalUser.get().getPassword().equals(password)))){
            return "incorrect password";
        }
        return null;
    }

    public void loginUser (String username){
        loggedInUsers.add(userRepository.findUserByUsername(username));
    }

    public void logoutUser (String username){
        loggedInUsers.remove(userRepository.findUserByUsername(username));
    }
}
