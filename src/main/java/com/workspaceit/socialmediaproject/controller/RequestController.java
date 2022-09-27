package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping("/{senderId}/{receiverId}")
    public void sendRequest(@PathVariable int senderId,@PathVariable int receiverId){
        System.out.println(senderId+" "+receiverId);
        requestService.addRequest(senderId, receiverId);
    }
}
