package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.Post;
import com.workspaceit.socialmediaproject.entity.User;
import com.workspaceit.socialmediaproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/posts")
    public ModelAndView viewPosts(@PathVariable int userId){
        ModelAndView allPostsByUser= new ModelAndView();
        allPostsByUser.setViewName("posts");
        allPostsByUser.addObject("allPosts", postService.getAllPostsFromUser(userId));
        return allPostsByUser;
//        List<String> s= new ArrayList<>();
//        ModelAndView allPosts= new ModelAndView();
//        allPosts.addObject("allposts", s );
//        return allPosts;
    }
}
