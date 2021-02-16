package com.greenfoxacademy.projectweekzero.repo;

import com.greenfoxacademy.projectweekzero.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
