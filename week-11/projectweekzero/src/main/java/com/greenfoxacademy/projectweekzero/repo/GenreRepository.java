package com.greenfoxacademy.projectweekzero.repo;

import com.greenfoxacademy.projectweekzero.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
