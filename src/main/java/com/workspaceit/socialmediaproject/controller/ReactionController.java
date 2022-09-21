package com.workspaceit.socialmediaproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/reaction")
public class ReactionController {

    @PostMapping("/upvote")
    public ModelAndView setUpvote(String url){
        System.out.println(url);
        return new ModelAndView("redirect:" + url);
    }
}
