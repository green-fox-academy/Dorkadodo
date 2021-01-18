package com.greenfoxacademy.todos.repository;

import com.greenfoxacademy.todos.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface TodoRepository extends CrudRepository<Todo, Long> {
    public List<Todo> findAllByDone(Boolean isDone);
}
