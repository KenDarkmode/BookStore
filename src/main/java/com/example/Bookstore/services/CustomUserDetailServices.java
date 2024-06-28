package com.example.Bookstore.services;

import com.example.Bookstore.entity.CustomUserDetail;
import com.example.Bookstore.entity.User;
import com.example.Bookstore.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailServices implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetail(user, userRepository);
    }
}