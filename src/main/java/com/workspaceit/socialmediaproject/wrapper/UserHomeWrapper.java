package com.workspaceit.socialmediaproject.wrapper;

import com.workspaceit.socialmediaproject.entity.User;

import java.util.List;

public class UserHomeWrapper {
    private int userId;
    private List<User> userList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
