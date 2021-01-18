package com.greenfoxacademy.todos;

import com.greenfoxacademy.todos.model.Todo;
import com.greenfoxacademy.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodosApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TodosApplication.class, args);
    }

    @Autowired
    TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}
