package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
