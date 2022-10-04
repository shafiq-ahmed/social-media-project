package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.User;
import com.workspaceit.socialmediaproject.wrapper.UserHomeWrapper;
import com.workspaceit.socialmediaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrationForm");
        return modelAndView;
    }

    @PostMapping (value = "/addUser")
    public ResponseEntity addUser( User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return ResponseEntity.status(200).body("User registered");

    }

    @GetMapping("/login/validation")
    public ModelAndView loginValidation(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        ModelAndView postView;

        postView= new ModelAndView("redirect:" +"http://localhost:9090/user/"+userId+"/home");
        return postView;
    }

    @GetMapping("/{userId}/home")
    public UserHomeWrapper getHome(@PathVariable int userId){
//        ModelAndView homeView= new ModelAndView();
//        homeView.addObject("userId",userId);
//        homeView.addObject("userList",userService.getAllUsers());
//        homeView.setViewName("home");
//        return homeView;

        UserHomeWrapper userHomeWrapper= new UserHomeWrapper();
        userHomeWrapper.setUserId(userId);
        userHomeWrapper.setUserList(userService.getAllUsers());
        return userHomeWrapper;
    }
}
