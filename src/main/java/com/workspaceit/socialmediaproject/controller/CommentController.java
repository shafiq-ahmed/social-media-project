package com.workspaceit.socialmediaproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
@RequestMapping(value = "comment")
public class CommentController {

    @GetMapping("/{postId}/{userId}")
    public ModelAndView postComment(@PathVariable String postId, @PathVariable String userId){
        System.out.println(postId+ " "+userId);
        ModelAndView commentView= new ModelAndView();
        commentView.setViewName("createcomment");
        return commentView;
    }
}
