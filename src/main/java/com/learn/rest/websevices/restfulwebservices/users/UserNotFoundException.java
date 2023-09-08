package com.learn.rest.websevices.restfulwebservices.users;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
