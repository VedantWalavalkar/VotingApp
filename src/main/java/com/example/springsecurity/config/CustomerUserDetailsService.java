package com.example.springsecurity.config;

import com.example.springsecurity.Models.User;
import com.example.springsecurity.Repository.UserRepository;
import com.example.springsecurity.Transformer.UserDetailsCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new RuntimeException("User Not Found");

        return new UserDetailsCreator(user);
    }
}
