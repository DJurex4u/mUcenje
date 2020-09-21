package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.User;
import com.google.firebase.auth.AuthResult;

public class AuthResultToUserMapper implements IMapper<AuthResult, User> {
    @Override
    public User map(AuthResult objectToMap) {
        return new User(objectToMap.getUser().getEmail(),parseEmailToUsername(objectToMap.getUser().getEmail()));
    }

    private String  parseEmailToUsername(String email){
        Integer indexOfMonkey = email.indexOf("@");
        return email.substring(0,indexOfMonkey);
    }
}