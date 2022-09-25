package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.Comment;
import com.workspaceit.socialmediaproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController()
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{postId}/{userId}")
    public ModelAndView writeComment(@PathVariable String postId, @PathVariable String userId){
        System.out.println(postId+ " "+userId);
        ModelAndView commentView= new ModelAndView();
        commentView.addObject("postId",postId);
        commentView.addObject("userId",userId);
        commentView.setViewName("createcomment");
        return commentView;
    }

    @PostMapping("/{postId}/{userId}/create")
    public ModelAndView createComment(@PathVariable int postId, @PathVariable int userId, Comment comment){

        commentService.addComment(comment,postId,userId);
        //commentService.addComment(comment,Integer.parseInt(postId),Integer.parseInt(userId));


        return new ModelAndView("redirect:" +"http://localhost:9090/comment/"+postId+"/allComments");
    }

    @GetMapping("/{postId}/allComments")
    public ModelAndView getAllCommentsForPost(@PathVariable int postId){
        ModelAndView allComments=new ModelAndView();
        allComments.addObject("allComments",commentService.findAllCommentsInPost(postId));
        allComments.setViewName("allcomments");
        return allComments;


    }
}
