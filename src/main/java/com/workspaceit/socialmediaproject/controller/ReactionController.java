package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/reaction")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;
    @PostMapping("/upvote/{postId}/{userId}")
    public ModelAndView setUpvote(@PathVariable int postId, @PathVariable int userId, String url){
        System.out.println(url+" "+postId+" "+userId);
        reactionService.setUpvote(postId,userId);
        return new ModelAndView("redirect:" + url);
    }
}
