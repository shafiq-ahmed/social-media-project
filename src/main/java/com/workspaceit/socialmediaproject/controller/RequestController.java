package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.Request;
import com.workspaceit.socialmediaproject.entity.RequestStatus;
import com.workspaceit.socialmediaproject.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView getAllReceivedRequests(@PathVariable int receiverId){
      //  requestService.getAllReceivedRequests(receiverId).forEach(i-> System.out.println(i.getId()+" "+i.getStatus()));
        ModelAndView requestView= new ModelAndView();
        requestView.setViewName("requests");
        requestView.addObject("receivedRequests",requestService.getAllReceivedRequests(receiverId));

        return requestView;
    }
    @PostMapping("/{requestId}/accept")
    public ModelAndView acceptRequest(@PathVariable int requestId, String redirectUrl){
        requestService.updateRequestStatus(requestId, RequestStatus.ACCEPTED);
        ModelAndView requestView= new ModelAndView();
        requestView.setViewName("redirect:"+redirectUrl);
        return requestView;
    }
    @PostMapping("/{requestId}/reject")
    public ModelAndView rejectRequest(@PathVariable int requestId, String redirectUrl){
        requestService.deleteRequest(requestId);
        ModelAndView requestView= new ModelAndView();
        requestView.setViewName("redirect:"+redirectUrl);
        return requestView;
    }
}
