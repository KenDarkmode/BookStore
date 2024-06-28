package com.example.Bookstore.entity;

import com.example.Bookstore.repository.IUserRepository;
import java.util.Collection;

public class CustomUserDetail implements UserDetails{
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    private final User user;
    private final IUserRepository userRepository;
    public CustomUserDetail(User user, IUserRepository userRepository) {
        this.user = user;
        this.userRepository = userRepository;
    }
}
