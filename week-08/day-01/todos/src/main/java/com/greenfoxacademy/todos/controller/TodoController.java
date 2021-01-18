package com.greenfoxacademy.todos.controller;

import com.greenfoxacademy.todos.model.Todo;
import com.greenfoxacademy.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

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

    @GetMapping("/new-todo")
    public String addNewTodo (){
        return "newTodo";
    }

    @PostMapping("/new-todo")
    public String saveNewTodo (@ModelAttribute Todo todo){
        todoRepository.save(todo);
        return "redirect:/list";
    }

    @GetMapping ("/delete-todo/{id}/delete")
    public String deleteTodo (@PathVariable Long id){
        todoRepository.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping ("/edit-todo/{id}/edit")
    public String editTodo (@PathVariable Long id, Model model){
        model.addAttribute("todo", todoRepository.findById(id));
        return "editTodo";
    }

    @PostMapping("/edit-todo")
    public String saveEditedTodo (@ModelAttribute Todo todo){
        todoRepository.save(todo);
        return "redirect:/list";
    }

    @GetMapping ("/todo-properties")
    public String propertiedOfTodo (@RequestParam Long id, Model model){
        model.addAttribute("todo", todoRepository.findById(id).get());
        return "todoproperties";
    }
}
