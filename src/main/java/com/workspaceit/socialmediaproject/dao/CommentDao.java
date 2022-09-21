package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Integer> {
}
