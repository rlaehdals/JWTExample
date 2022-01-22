package com.example.jwtsecurity.exception;

public class UserDuplicateException extends RuntimeException{

    public UserDuplicateException(String message) {
        super(message);
    }
}
