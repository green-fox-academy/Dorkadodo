package com.greenfoxacademy.reddit.repo;

import com.greenfoxacademy.reddit.model.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CrudRepository <Label, Long> {
    public Label findByLabelName(String name);
}
