package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostDao extends JpaRepository<Post, Integer> {
    List<Post> findByUser_Id(int id);
}
