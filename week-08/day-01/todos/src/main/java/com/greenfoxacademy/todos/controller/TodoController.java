package com.greenfoxacademy.todos.controller;

import com.greenfoxacademy.todos.model.Assignee;
import com.greenfoxacademy.todos.model.Todo;
import com.greenfoxacademy.todos.service.AssigneeService;
import com.greenfoxacademy.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;
    @Autowired
    private AssigneeService assigneeService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("todoList", todoService.getAllTodos());
        return "todolist";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/list";
    }

    @GetMapping("/active-todos")
    public String activeTodos(Model model) {
        model.addAttribute("todoList", todoService.getActiveTodos());
        return "todolist";
    }

    @GetMapping("/new-todo")
    public String addNewTodo() {
        return "newTodo";
    }

    @PostMapping("/new-todo")
    public String saveNewTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/list";
    }

    @GetMapping("/delete-todo/{id}/delete")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/list";
    }

    @GetMapping("/edit-todo")
    public String editTodo(@RequestParam Long id, Model model) {
        model.addAttribute("todo", todoService.getTodoById(id));
        model.addAttribute("assigneeList", assigneeService.getAssigneeList());
        return "editTodo";
    }

    @PostMapping("/edit-todo")
    public String saveEditedTodo(@ModelAttribute Todo todo, String assigneeName) {
        todoService.addAssignee(todo.getId(), assigneeService.getAssigneeByName(assigneeName).getId());
        todoService.addTodo(todo);
        return "redirect:/list";
    }

    @GetMapping("/todo-properties")
    public String propertiedOfTodo(@RequestParam Long id, Model model) {
        model.addAttribute("todo", todoService.getTodoById(id));
        return "todoproperties";
    }

    @PostMapping("/search-todo")
    public String search(@RequestParam String searchString, Assignee assignee, Model model) {
        model.addAttribute("todoList", todoService.searchByString(searchString));
        return "todolist";
    }

    @GetMapping("/new-assignee")
    public String createNewAssignee() {
        return "newAssignee";
    }

    @PostMapping("/new-assignee")
    public String saveNewAssignee(String name, String email) {
        assigneeService.newAssignee(name, email);
        return "redirect:/list";
    }

    @GetMapping("/assignees")
    public String showAllAssignees(Model model) {
        model.addAttribute("assigneeList", assigneeService.getAssigneeList());
        return "assigneelist";
    }

    @GetMapping("/assignee-todos")
    public String assigneeTodos(@RequestParam Long id, Model model){
        model.addAttribute("assigneeTodos", assigneeService.getTodosOfAssigneeOfId(id));
    model.addAttribute("assignee", assigneeService.getNameOfAssigneeID(id));
    return "assigneeTodos";
    }
}
