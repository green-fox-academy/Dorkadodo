package com.greenfoxacademy.todos.service;

import com.greenfoxacademy.todos.model.Assignee;
import com.greenfoxacademy.todos.model.Todo;
import com.greenfoxacademy.todos.repository.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssigneeService {

    @Autowired
    private AssigneeRepository assigneeRepository;

    public List<Assignee> getAssigneeList (){
        return (List<Assignee>) assigneeRepository.findAll();
    }

    public void newAssignee (String name, String email){
        assigneeRepository.save(new Assignee(name, email));
    }

    public List<Todo> getTodosOfAssigneeOfId (Long assigneeID){
        List<Todo>todos = new ArrayList<>();
        return todos;
    }

    public String getNameOfAssigneeID (Long ID){
        return assigneeRepository.findById(ID).get().getName();
    }

    public Assignee getAssigneeByName (String name){
        return assigneeRepository.findAssigneeByName(name);
    }
}
