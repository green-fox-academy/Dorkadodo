package com.greenfoxacademy.reddit.repo;

import com.greenfoxacademy.reddit.model.Label;
import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query(value = "SELECT * FROM post p ORDER BY p.vote_count DESC, p.id ASC LIMIT 10 OFFSET :offsetnumber", nativeQuery = true)
    public List<Post> getAllPostsByPageNumber(@Param("offsetnumber") Long offsetnumber);

    @Query(value = "SELECT title, description, vote_count, date_of_creation, p.id, user_id FROM post p INNER JOIN label_tagged l ON p.id = l.post_id WHERE l.label_id = :label ORDER BY p.vote_count DESC, p.id ASC LIMIT 10 OFFSET :offsetnumber", nativeQuery = true)
    public List<Post> getPostsOfPageByAddedLabels(@Param("offsetnumber") Long offsetnumber, @Param("label") Long label);

    public Long countAllByAddedLabels(Label label);
}
