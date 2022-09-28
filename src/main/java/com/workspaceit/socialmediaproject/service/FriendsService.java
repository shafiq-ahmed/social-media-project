package com.workspaceit.socialmediaproject.service;

import com.workspaceit.socialmediaproject.dao.FriendsDao;
import com.workspaceit.socialmediaproject.entity.Friends;
import com.workspaceit.socialmediaproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsService {
    @Autowired
    private FriendsDao friendsDao;

    public void addFriends(User user, User friend){
        Friends friends= new Friends();
        friends.setUser(user);
        friends.setFriend(friend);
        friendsDao.save(friends);
    }

    public boolean isUserFriend(int friendId, int userId){
        Friends friends=friendsDao.findByFriendIdAndUserId(friendId,userId);
        if(friends==null) {
            System.out.println(false);
            //switching ids to see if the relationship exists from opposite side
            friends=friendsDao.findByFriendIdAndUserId(userId,friendId);
        }
        if(friends==null){
            System.out.println(false);
            return false;
        }else {
            System.out.println(true);
            return true;
        }

    }
}
