package com.workspaceit.socialmediaproject.service;

import com.workspaceit.socialmediaproject.dao.FriendsDao;
import com.workspaceit.socialmediaproject.entity.Friends;
import com.workspaceit.socialmediaproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            //switching ids to see if the relationship exists from opposite side
            friends=friendsDao.findByFriendIdAndUserId(userId,friendId);
        }
        if(friends==null){
            return false;
        }else {
            return true;
        }

    }

    public List<User> getFriends(int userId){
       List<Friends> friends= friendsDao.findByUserId(userId);
       List<User> users= new ArrayList<>();
       for(Friends friend: friends){
           users.add(friend.getFriend());
       }
       //finding friends who are mapped as users opposite to this userID
       friends=friendsDao.findByFriendId(userId);
        for(Friends friend: friends){
            users.add(friend.getUser());
        }
       return users;
    }
}
