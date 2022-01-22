package com.example.jwtsecurity.service;


import com.example.jwtsecurity.domain.User;
import com.example.jwtsecurity.exception.UserDuplicateException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService{

    User join(String email, String password) throws UserDuplicateException;


    User login(String email, String password) throws UsernameNotFoundException, BadCredentialsException, Throwable;

}
