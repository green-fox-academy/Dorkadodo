package com.greenfoxacademy.todos.repository;

import com.greenfoxacademy.todos.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository()
public interface TodoRepository extends CrudRepository<Todo, Long> {
    public List<Todo> findAllByDone(Boolean isDone);

    @Query(value = "SELECT title, urgent, done, date_of_creation, name FROM todo INNER JOIN assignee on todo.assignee_id=assignee.id",nativeQuery = true)
    public List<Todo> findAllTodosWithAssigneeNames ();
}
