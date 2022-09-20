package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.Post;
import com.workspaceit.socialmediaproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/createpost")
    public ModelAndView createPost(){
        ModelAndView postView= new ModelAndView();
        postView.setViewName("createpost");
        return postView;
    }
    @PostMapping("/submit")
    public ResponseEntity submitPost(Post post){
        postService.addPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body("Post created");
    }
}
