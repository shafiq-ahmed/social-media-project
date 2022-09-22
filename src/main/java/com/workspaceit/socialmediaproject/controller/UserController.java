package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.User;
import com.workspaceit.socialmediaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addUser( User user){
       // System.out.println(user);
        userService.addUser(user);
        return ResponseEntity.status(200).body("User registered");

    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login/validation")
    public ModelAndView loginValidation(User user){

        User validatedUser=userService.validateLogin(user);
        ModelAndView postView;
        if(validatedUser==null){

            postView= new ModelAndView("redirect:" +"http://localhost:9090/user/login");

        }else{
           postView= new ModelAndView("redirect:" +"http://localhost:9090/post/"+user.getId()+"/posts/"+user.getId());

        }
        return postView;
    }
}
