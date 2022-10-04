package com.workspaceit.socialmediaproject.wrapper;

import com.workspaceit.socialmediaproject.entity.Post;
import com.workspaceit.socialmediaproject.entity.User;

import java.util.List;

public class PostsWrapper {
    private boolean requestExists;
    private boolean isOwnProfile;
    private List<User> friendsList;
    private boolean isFriend;
    private int userId;
    private int viewerId;
    private List<Post> allPosts;

    public boolean isRequestExists() {
        return requestExists;
    }

    public void setRequestExists(boolean requestExists) {
        this.requestExists = requestExists;
    }

    public boolean isOwnProfile() {
        return isOwnProfile;
    }

    public void setOwnProfile(boolean ownProfile) {
        isOwnProfile = ownProfile;
    }

    public List<User> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<User> friendsList) {
        this.friendsList = friendsList;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getViewerId() {
        return viewerId;
    }

    public void setViewerId(int viewerId) {
        this.viewerId = viewerId;
    }

    public List<Post> getAllPosts() {
        return allPosts;
    }

    public void setAllPosts(List<Post> allPosts) {
        this.allPosts = allPosts;
    }
}
