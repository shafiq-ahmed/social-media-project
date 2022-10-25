package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostId(int postId);
    int countByPostId(int postId);
}
