package com.example.springsecurity6_thymeleaf.service.impl;

import com.example.springsecurity6_thymeleaf.entiry.Users;
import com.example.springsecurity6_thymeleaf.repository.UserRepository;
import com.example.springsecurity6_thymeleaf.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.getUserByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Could not find user: " + username);

        }
        return new MyUserService(user);
    }
}
