package com.workspaceit.socialmediaproject.service;

import com.workspaceit.socialmediaproject.dao.PostDao;
import com.workspaceit.socialmediaproject.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostDao postDao;

    public void addPost(Post post){
        postDao.save(post);
    }
}
