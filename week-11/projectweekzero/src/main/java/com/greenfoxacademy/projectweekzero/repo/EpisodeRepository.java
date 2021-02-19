package com.greenfoxacademy.projectweekzero.repo;

import com.greenfoxacademy.projectweekzero.model.Episode;
import org.springframework.data.repository.CrudRepository;

public interface EpisodeRepository extends CrudRepository<Episode, Integer> {
}
