package com.greenfoxacademy.urlaliaser.repo;

import com.greenfoxacademy.urlaliaser.model.URLalias;
import org.springframework.data.repository.CrudRepository;

public interface URLaliasRepository extends CrudRepository<URLalias, Long> {
    URLalias findFirstByAlias(String alias);
}
