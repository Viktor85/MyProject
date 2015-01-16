package com.my.messages.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.my.messages.dao.UserDao;
import com.my.messages.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


public class CustomUserDetailsService implements UserDetailsService {

        @Autowired
        private UserDao userDao;
     @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName)  throws UsernameNotFoundException {

        com.my.messages.model.User domainUser = userDao.getUser(userName);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
                domainUser.getUserName(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRoles())
        );
    }

    private Collection < ? extends GrantedAuthority> getAuthorities(List<Role> roles) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }






}


