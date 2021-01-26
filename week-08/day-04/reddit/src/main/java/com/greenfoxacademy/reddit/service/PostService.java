package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Label;
import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private LabelService labelService;

    public List<Post> getPosts(String pageNumber, String labelName) {
        Long pageNumberLong = pageNumberToLong(pageNumber);
        if (labelName == null) {
            return postRepository.getAllPostsByPageNumber((pageNumberLong - 1) * 10);
        }
        return postRepository.getPostsOfPageByAddedLabels((pageNumberLong - 1) * 10, labelService.getLabelByName(labelName).getId());
    }

    public List<String> getPageNumbers(String pageNumberString, String label) {
        Long pageNumber = pageNumberToLong(pageNumberString);
        Long pageCount = numberOfPages(label);
        List<String> pages = getDisplayablePageNumbers(pageNumber, pageCount);
        return pages;
    }

    private List<String> getDisplayablePageNumbers(Long pageNumber, Long pageCount) {
        if (pageNumber > pageCount){
            pageNumber = 1L;
        }
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
        return pageNumberLong;
    }

    private Long numberOfPages (String labelName){
        if (labelName == null) {
            return (postRepository.count() / 10) + 1;
        }
        return postRepository.countAllByAddedLabels(labelService.getLabelByName(labelName)) / 10 + 1;
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

    public void addUserToPost(Post post, String userName){
        post.setUser(userService.getUserByName(userName));
    }

    public void addLabelToPost(Long postID, String addedLabel){
        Optional<Post> optionalPost = postRepository.findById(postID);
        if (optionalPost.isEmpty()){
            return;
        }
        Post post = optionalPost.get();

        Label newLabel = labelService.getLabelByName(addedLabel);
        if (newLabel == null){
            return;
        }
        post.getAddedLabels().add(newLabel);
        postRepository.save(post);
    }

    public List<String> getAssignedLabelsByPostId (Long postID){
        Optional<Post> optionalPost = postRepository.findById(postID);
        if(optionalPost.isEmpty()){
            return null;
        }
        List<String> assignedLabels = optionalPost.get().getAddedLabels()
                .stream()
                .map(label -> label.getLabelName())
                .collect(Collectors.toList());
        return assignedLabels;
    }

}
