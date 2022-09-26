package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.Post;
import com.workspaceit.socialmediaproject.service.CommentService;
import com.workspaceit.socialmediaproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/post/{userId}")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/createpost")
    public ModelAndView createPost(@PathVariable int userId){
        ModelAndView postView= new ModelAndView();
        postView.setViewName("createpost");
        postView.addObject("userId",userId);
        return postView;
    }
    @PostMapping("/submit")
    public ModelAndView submitPost(Post post,@PathVariable("userId") int userId ){

        if(postService.postUserExists(userId)){
            postService.addPost(post, userId);
            return new ModelAndView("redirect:"+"http://localhost:9090/post/"+userId+"/posts/"+userId);
        }else{
            return new ModelAndView("error").addObject("errorMessage","User not found");
        }

    }

    @GetMapping("/posts/{viewerId}")
    public ModelAndView viewPosts(@PathVariable int userId, @PathVariable int viewerId){
        ModelAndView allPostsByUser= new ModelAndView();
        allPostsByUser.setViewName("posts");
        allPostsByUser.addObject("allPosts", postService.getAllPostsFromUser(userId));
        allPostsByUser.addObject("userId",userId);
        allPostsByUser.addObject("viewerId",viewerId);
        return allPostsByUser;
    }

    @GetMapping("/viewUserProfile")
    public ModelAndView getSelectedUserPost(@PathVariable("userId") int userId,int selectedUserId){
        ModelAndView postView= new ModelAndView("redirect:" +"http://localhost:9090/post/"+selectedUserId+"/posts/"+userId);
        return postView;
    }
}
