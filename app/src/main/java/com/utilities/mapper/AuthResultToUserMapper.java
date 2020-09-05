package com.utilities.mapper;

import com.data.entities.User;
import com.google.firebase.auth.AuthResult;

public class AuthResultToUserMapper implements IMapper<AuthResult, User> {
    @Override
    public User map(AuthResult objectToMap) {
        return new User(objectToMap.getUser().getEmail());
    }
}
