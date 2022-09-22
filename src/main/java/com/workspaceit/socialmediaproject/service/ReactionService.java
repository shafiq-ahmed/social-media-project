package com.workspaceit.socialmediaproject.service;

import com.workspaceit.socialmediaproject.dao.PostDao;
import com.workspaceit.socialmediaproject.dao.ReactionDao;
import com.workspaceit.socialmediaproject.dao.UserDao;
import com.workspaceit.socialmediaproject.entity.Reaction;
import com.workspaceit.socialmediaproject.entity.UserReact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionService {
    @Autowired
    private ReactionDao reactionDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

    public void setUpvote(int postId, int userId){
        System.out.println("here");
        Reaction reaction=reactionDao.findByPostIdAndUserId(postId,userId);
        if(reaction!=null){

            if(reaction.getUserReact()==UserReact.UPVOTE){
                reaction.setUserReact(UserReact.NONE);
            }else reaction.setUserReact(UserReact.UPVOTE);



        }else{
            reaction=new Reaction();
            reaction.setPost(postDao.getReferenceById(postId));
            reaction.setUser(userDao.getReferenceById(userId));
            reaction.setUserReact(UserReact.UPVOTE);
        }
        reactionDao.save(reaction);
//

//        System.out.println(reaction.getPost().getId());
//        System.out.println(reaction.getUser().getId());
    }

    public void setDownvote(int postId, int userId){
        System.out.println("here");
        Reaction reaction=reactionDao.findByPostIdAndUserId(postId,userId);
        if(reaction!=null){

            if(reaction.getUserReact()==UserReact.DOWNVOTE){
                reaction.setUserReact(UserReact.NONE);
            }else reaction.setUserReact(UserReact.DOWNVOTE);



        }else{
            reaction=new Reaction();
            reaction.setPost(postDao.getReferenceById(postId));
            reaction.setUser(userDao.getReferenceById(userId));
            reaction.setUserReact(UserReact.DOWNVOTE);
        }
        reactionDao.save(reaction);
//

//        System.out.println(reaction.getPost().getId());
//        System.out.println(reaction.getUser().getId());
    }
}
