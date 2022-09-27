package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/viewRequests/{receiverId}")
    public ResponseEntity getAllReceivedRequests(@PathVariable int receiverId){
      //  requestService.getAllReceivedRequests(receiverId).forEach(i-> System.out.println(i.getId()+" "+i.getStatus()));
        return new ResponseEntity(requestService.getAllReceivedRequests(receiverId), HttpStatus.OK);
    }
}
