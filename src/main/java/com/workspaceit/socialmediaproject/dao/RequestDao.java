package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Request;
import com.workspaceit.socialmediaproject.entity.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestDao extends JpaRepository<Request, Integer> {
    public Request findBySenderIdAndReceiverId(int senderId, int receiverId);
    public List<Request> findByReceiverIdAndStatus(int receiverId, RequestStatus status);

}
