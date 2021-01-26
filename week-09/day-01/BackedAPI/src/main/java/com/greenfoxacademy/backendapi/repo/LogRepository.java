package com.greenfoxacademy.backendapi.repo;

import com.greenfoxacademy.backendapi.model.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {

    @Query(value = "SELECT * FROM log ORDER BY created_at DESC LIMIT :count", nativeQuery = true)
    public Iterable<Log> findAllWithCount(@Param(value = "count") Long count);

    @Query(value = "SELECT * FROM log ORDER BY created_at DESC LIMIT :count OFFSET :offset", nativeQuery = true)
    public Iterable<Log> findAllWithCountAndPage(@Param(value = "count") Long count, @Param(value = "offset") Long offset);
}
