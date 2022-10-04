package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.Comment;
import com.workspaceit.socialmediaproject.service.CommentService;
import com.workspaceit.socialmediaproject.wrapper.CommentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{postId}/{userId}")
    public ModelAndView writeComment(@PathVariable String postId, @PathVariable String userId){
        ModelAndView commentView= new ModelAndView();
        commentView.addObject("postId",postId);
        commentView.addObject("userId",userId);
        commentView.setViewName("createcomment");
        return commentView;

    }

    @PostMapping("/{postId}/{userId}/create")
    public ResponseEntity createComment(@PathVariable int postId, @PathVariable int userId, Comment comment){

        commentService.addComment(comment,postId,userId);
        HttpHeaders headers= new HttpHeaders();
        headers.add("Location", "http://localhost:9090/comment/"+postId+"/allComments");
        return new ResponseEntity(headers, HttpStatus.OK);
        //return new ModelAndView("redirect:" +"http://localhost:9090/comment/"+postId+"/allComments");
    }

    @GetMapping("/{postId}/allComments")
    public CommentWrapper getAllCommentsForPost(@PathVariable int postId){
//        ModelAndView allComments=new ModelAndView();
//        allComments.addObject("allComments",commentService.findAllCommentsInPost(postId));
//        allComments.setViewName("allcomments");
//        return allComments;
        CommentWrapper commentWrapper= new CommentWrapper();
        commentWrapper.setCommentList(commentService.findAllCommentsInPost(postId));

        return commentWrapper;


    }
}
