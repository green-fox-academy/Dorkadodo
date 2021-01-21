package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts(String pageNumber) {
        Long pageNumberLong;
        try {
            pageNumberLong = Long.valueOf(pageNumber);
        } catch (NumberFormatException ex){
            pageNumberLong = 1L;
        }
        if (pageNumberLong > getPages().size()){
            pageNumberLong = 1L;
        }
        List<Post> postsOfPage = postRepository.getPostsByPageNumber((pageNumberLong - 1) * 10);
        return postsOfPage;
    }

    public void addNewPost(Post post) {
        postRepository.save(post);
    }

    public Post getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return optionalPost.get();
        }
        return null;
    }

    public void upvotePost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (!(optionalPost.isPresent())) {
            return;
        }
        Post post = optionalPost.get();
        post.setVoteCount(post.getVoteCount() + 1);
        postRepository.save(post);
    }

    public void downvotePost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (!(optionalPost.isPresent())) {
            return;
        }
        Post post = optionalPost.get();
        post.setVoteCount(post.getVoteCount() - 1);
        postRepository.save(post);
    }

    public List<String> getPages() {
        Long pageCount = (postRepository.count() / 10) + 1;
        List<String> pages = new ArrayList<>();
        for (int i = 0; i < pageCount; i++) {
            pages.add(String.valueOf(i + 1));
        }
        return pages;
    }
}
