package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.User;
import com.workspaceit.socialmediaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrationForm");
        return modelAndView;
    }

    @PostMapping (value = "/register",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addUser( User user){
       // System.out.println(user);
        userService.addUser(user);
    }
}
