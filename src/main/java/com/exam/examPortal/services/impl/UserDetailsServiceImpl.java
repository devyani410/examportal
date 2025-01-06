package com.exam.examPortal.services.impl;

import com.exam.examPortal.entity.User;
import com.exam.examPortal.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByuserName(username);
        if(user!=null){
            System.out.println("No User found");
            throw new UsernameNotFoundException("User Not found");
        }
        return  user;
    }
}

