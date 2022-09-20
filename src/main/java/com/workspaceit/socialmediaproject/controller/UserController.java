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
    public void addUser( User user){
       // System.out.println(user);
        userService.addUser(user);
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/login/validation")
    public ResponseEntity loginValidation(User user){

        User validatedUser=userService.validateLogin(user);
        if(validatedUser==null){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("User id or password does not match");
        }else{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(validatedUser);
        }

    }
}
