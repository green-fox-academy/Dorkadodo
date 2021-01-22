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
        Long pageNumberLong = pageNumberToLong(pageNumber);
        List<Post> postsOfPage = postRepository.getPostsByPageNumber((pageNumberLong - 1) * 10);
        return postsOfPage;
    }

    public List<String> getPageNumbers(String pageNumberString) {
        Long pageNumber = pageNumberToLong(pageNumberString);
        Long pageCount = numberOfPages();
        List<String> pages = new ArrayList<>();

        if (pageNumber <= 4){
            if (pageCount < 7){
                for (int i = 0; i < pageCount; i++) {
                    pages.add(String.valueOf(i + 1));
                }
            } else {
                for (int i = 0; i < 7; i++) {
                    pages.add(String.valueOf(i + 1));
                }
            }
        } else if ((pageCount - pageNumber) <= 3) {
            for (int i = 0; i < 7; i++) {
                pages.add(String.valueOf(pageCount - (6 - i)));
            }
        } else {
            for (int i = 0; i < 7; i++) {
                pages.add(String.valueOf(pageNumber - 3 + i));
            }
        }

        return pages;
    }

    private Long pageNumberToLong(String pageNumber) {
        Long pageNumberLong;
        try {
            pageNumberLong = Long.valueOf(pageNumber);
        } catch (NumberFormatException ex){
            pageNumberLong = 1L;
        }
        if (pageNumberLong > numberOfPages()){
            pageNumberLong = 1L;
        }
        return pageNumberLong;
    }

    private Long numberOfPages (){
        return  (postRepository.count() / 10) + 1;
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
}
