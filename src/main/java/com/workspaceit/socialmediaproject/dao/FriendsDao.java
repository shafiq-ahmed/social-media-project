package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsDao extends JpaRepository<Friends, Integer> {
    public Friends findByFriendIdAndUserId(int friendId, int userId);
    public List<Friends> findByUserId(int userId);
    public List<Friends> findByFriendId(int friendId);
}
