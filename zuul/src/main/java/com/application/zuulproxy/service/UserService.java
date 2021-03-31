package com.application.zuulproxy.service;

import com.application.zuulproxy.api.UserApi;
import com.application.zuulproxy.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserApi userApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("123 "+username);
        Users user= userApi.findUserByUsername(username);
        return User.withUsername(user.getUsername()).roles(user.getRole()).password(user.getPassword()).build();
    }
}
