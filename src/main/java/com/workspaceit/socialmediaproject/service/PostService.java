package com.workspaceit.socialmediaproject.service;

import com.workspaceit.socialmediaproject.dao.PostDao;
import com.workspaceit.socialmediaproject.dao.ReactionDao;
import com.workspaceit.socialmediaproject.dao.UserDao;
import com.workspaceit.socialmediaproject.entity.Post;
import com.workspaceit.socialmediaproject.entity.Reaction;
import com.workspaceit.socialmediaproject.entity.User;
import com.workspaceit.socialmediaproject.entity.UserReact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReactionDao reactionDao;
    public void addPost(Post post,int userId) {

        post.setUser(userDao.getReferenceById(userId));
        postDao.save(post);

    }

    public boolean postUserExists(int userId){

        if(userDao.existsById(userId))
            return true;
        else return false;
    }
    public List<Post> getAllPostsFromUser(int userId){
         return postDao.findByUserId(userId);
    }

    public int getNumberOfReacts(int postId){
       // Post post=postDao.getReferenceById(postId);
        return 0;
    }

    public int getNumberOfUpvotes(int postId){
        return reactionDao.countByPostIdAndUserReact(postId, UserReact.UPVOTE);
    }
}
