package com.greenfoxacademy.todos.repository;

import com.greenfoxacademy.todos.model.Assignee;
import org.springframework.data.repository.CrudRepository;

public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    public Assignee findAssigneeByName (String name);
}
