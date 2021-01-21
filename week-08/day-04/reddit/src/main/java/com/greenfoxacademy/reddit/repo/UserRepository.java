package com.greenfoxacademy.reddit.repo;

import com.greenfoxacademy.reddit.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername (String username);
}
