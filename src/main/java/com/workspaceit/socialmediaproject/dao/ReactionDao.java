package com.workspaceit.socialmediaproject.dao;

import com.workspaceit.socialmediaproject.entity.Reaction;
import com.workspaceit.socialmediaproject.entity.UserReact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReactionDao extends JpaRepository<Reaction, Integer> {
    Reaction findByPostIdAndUserId(int postId, int userId);
     List<Reaction> findAllByPostIdAndUserReact(int postId, UserReact userReact);
}
