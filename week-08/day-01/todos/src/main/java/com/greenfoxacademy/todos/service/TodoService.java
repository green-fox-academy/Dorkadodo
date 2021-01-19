package com.greenfoxacademy.todos.service;

import com.greenfoxacademy.todos.model.Assignee;
import com.greenfoxacademy.todos.model.Todo;
import com.greenfoxacademy.todos.repository.AssigneeRepository;
import com.greenfoxacademy.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private AssigneeRepository assigneeRepository;

    public List<Todo> getAllTodos (){
        return (List<Todo>) todoRepository.findAll();
    }

    public List<Todo> getActiveTodos (){
        return todoRepository.findAllByDone(false);
    }

    public void addTodo(Todo newTodo){
        todoRepository.save(newTodo);
    }

    public void deleteTodo (Long id){
        todoRepository.deleteById(id);
    }

    public Todo getTodoById (Long id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isEmpty()){
            return null;
        }
        return optionalTodo.get();
    }

    public List<Todo> searchByString (String searchString){
        List<Todo> searchResult = ((List<Todo>) todoRepository.findAll()).stream()
                .filter(todo -> todo.getTitle().contains(searchString))
                .collect(Collectors.toList());
        return searchResult;
    }

    public void addAssignee (Long id, Long assigneeID){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Optional<Assignee> optionalAssignee = assigneeRepository.findById(assigneeID);
        if (optionalTodo.isPresent() && optionalAssignee.isPresent()) {
            Todo updatedTodo = optionalTodo.get();
            updatedTodo.setAssignee(optionalAssignee.get());
            todoRepository.save(updatedTodo);
        }
    }
}
