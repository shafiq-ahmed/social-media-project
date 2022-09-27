package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDao extends JpaRepository<Request, Integer> {
    public Request findBySenderIdAndReceiverId(int senderId, int receiverId);
}
