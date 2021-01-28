package com.greenfoxacademy.resttest.repo;

import com.greenfoxacademy.resttest.model.Ammunition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmmunitionRepository extends CrudRepository<Ammunition, Long> {
    public Ammunition findByCaliber(String caliber);
}
