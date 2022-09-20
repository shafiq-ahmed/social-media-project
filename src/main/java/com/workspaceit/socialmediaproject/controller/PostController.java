package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.Post;
import com.workspaceit.socialmediaproject.entity.User;
import com.workspaceit.socialmediaproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/post/{userId}")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/createpost")
    public ModelAndView createPost(@PathVariable int userId){
        ModelAndView postView= new ModelAndView();
        postView.setViewName("createpost");
        postView.addObject("userId",userId);
        return postView;
    }
    @PostMapping("/submit")
    public ResponseEntity submitPost(Post post,@PathVariable("userId") int userId ){

        if(postService.postUserExists(userId)){
            postService.addPost(post, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body("Post created");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }

    }
}
