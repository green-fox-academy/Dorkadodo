package com.greenfoxacademy.todos.controller;

import com.greenfoxacademy.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.GeneratedValue;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping ("/todo")
    public String todoMain (){
        return "index";
    }

    @GetMapping ("/list")
    public String list (Model model){
        model.addAttribute("todoList", todoRepository.findAll());
        return "todolist";
    }

    @GetMapping ("/")
    public String root (){
        return "redirect:/list";
    }

    @GetMapping ("/active-todos")
    public String activeTodos (Model model){
        model.addAttribute("todoList", todoRepository.findAllByDone(false));
        return "todolist";
    }
}
