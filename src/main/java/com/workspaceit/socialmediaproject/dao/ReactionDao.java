package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReactionDao extends JpaRepository<Reaction, Integer> {
    Reaction findByPostIdAndUserId(int postId, int userId);

}
