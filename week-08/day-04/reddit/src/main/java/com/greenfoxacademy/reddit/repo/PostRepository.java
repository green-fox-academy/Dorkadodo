package com.greenfoxacademy.reddit.repo;

import com.greenfoxacademy.reddit.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query(value = "SELECT * FROM post p ORDER BY p.vote_count DESC LIMIT 10 OFFSET :offsetnumber", nativeQuery = true)
    public List<Post> getPostsByPageNumber (@Param("offsetnumber") Long offsetnumber);
}
