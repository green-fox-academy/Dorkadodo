package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Label;
import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repo.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private PostService postService;

    public List<String> getAllLabelNames (){
        List<String> labelNames = ((List<Label>)labelRepository.findAll()).stream()
                .map(label -> label.getLabelName())
                .collect(Collectors.toList());
        return labelNames;
    }

    public List<String> getNotAssignedLabels (Long postID){
        Post post = postService.getPostById(postID);
        if(post == null){
            return null;
        }
        List<String> assignedLabels = postService.getAssignedLabelsByPostId(postID);
        List<String> notAssignedLabels = ((List<Label>)labelRepository.findAll()).stream()
                .map(label -> label.getLabelName())
                .filter(label -> !assignedLabels.contains(label))
                .collect(Collectors.toList());
        return notAssignedLabels;
    }

    public Label getLabelByName(String addedLabel){
        return labelRepository.findByLabelName(addedLabel);
    }
}
