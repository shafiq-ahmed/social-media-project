package com.workspaceit.socialmediaproject.service;

import com.workspaceit.socialmediaproject.dao.CommentDao;
import com.workspaceit.socialmediaproject.dao.PostDao;
import com.workspaceit.socialmediaproject.dao.UserDao;
import com.workspaceit.socialmediaproject.entity.Comment;
import com.workspaceit.socialmediaproject.entity.Post;
import com.workspaceit.socialmediaproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

    public void addComment(Comment comment, int postId, int userId){
        comment.setUser(findUser(userId));
        comment.setPost(findPost(postId));
        commentDao.save(comment);
    }

    public Post findPost(int postId){
        return postDao.getReferenceById(postId);
    }

    public User findUser(int userId){
        return userDao.getReferenceById(userId);
    }

    public List<Comment> findAllCommentsInPost(int postId){
        return commentDao.findByPostId(postId);
    }
    public int getNumberOfComments(int postId){
        return commentDao.countByPostId(postId);
    }
}
