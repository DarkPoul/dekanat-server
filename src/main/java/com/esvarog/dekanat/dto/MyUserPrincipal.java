package com.esvarog.dekanat.dto;

import com.esvarog.dekanat.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;

public class MyUserPrincipal implements UserDetails {

    private final Users user;

    public MyUserPrincipal(Users user) {
        this.user = user;
    }

    public static MyUserPrincipal create(Users user) {

        MyUserPrincipal myUserPrincipal = new MyUserPrincipal(null);
        myUserPrincipal.user.setId(user.getId());
        myUserPrincipal.user.setEnabled(user.isEnabled());
        myUserPrincipal.user.setPassword(user.getPassword());
        myUserPrincipal.user.setRole(user.getRole());
        myUserPrincipal.user.setUsername(user.getUsername());
        myUserPrincipal.user.setToken(user.getToken());
        myUserPrincipal.user.setTokenExpire(user.getTokenExpire());

        return myUserPrincipal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.stream(StringUtils.tokenizeToStringArray(this.user.getRole(), ","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }

    public Users getUser() {
        return user;
    }
}