package com.workspaceit.socialmediaproject.config;

import com.workspaceit.socialmediaproject.dao.UserDao;
import com.workspaceit.socialmediaproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user= userDao.getReferenceById(Integer.parseInt(username));
        if(user==null){
            throw new UsernameNotFoundException("User could not be found");
        }
        SystemUserDetails systemUserDetails= new SystemUserDetails(user);
        return systemUserDetails;
    }
}
