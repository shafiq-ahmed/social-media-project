package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionDao extends JpaRepository<Reaction, Integer> {
    Reaction findByPostIdAndUserId(int postId, int userId);
}
