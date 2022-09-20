package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Integer> {
}
