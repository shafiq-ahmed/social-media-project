package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsDao extends JpaRepository<Friends, Integer> {

}
