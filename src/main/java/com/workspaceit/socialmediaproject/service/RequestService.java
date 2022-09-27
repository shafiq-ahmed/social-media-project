package com.workspaceit.socialmediaproject.service;

import com.workspaceit.socialmediaproject.dao.RequestDao;
import com.workspaceit.socialmediaproject.dao.UserDao;
import com.workspaceit.socialmediaproject.entity.Request;
import com.workspaceit.socialmediaproject.entity.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    @Autowired
    private RequestDao requestDao;
    @Autowired
    private UserDao userDao;

    public void addRequest(int senderId, int receeiverId) {
        Request request;
        if (userDao.existsById(senderId) && userDao.existsById(receeiverId)) {
            request = requestDao.findBySenderIdAndReceiverId(senderId, receeiverId);
            if (request == null) {
                request = new Request();
                request.setSender(userDao.getReferenceById(senderId));
                request.setReceiver(userDao.getReferenceById(receeiverId));
            }
                request.setStatus(RequestStatus.PENDING);
                requestDao.save(request);
        }
    }
}

