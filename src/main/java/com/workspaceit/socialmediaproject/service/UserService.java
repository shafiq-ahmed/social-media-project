package com.workspaceit.socialmediaproject.service;

import com.workspaceit.socialmediaproject.dao.UserDao;
import com.workspaceit.socialmediaproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public void addUser(User user) {
        userDao.save(user);
    }


    public List<User> getAllUsers(){
        return userDao.findAll();
    }
}
