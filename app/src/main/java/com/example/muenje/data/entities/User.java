package com.example.muenje.data.entities;

import java.io.Serializable;

public class User implements Serializable {
    public final String mEmail;
    public final String mDisplayName;

    public User(String email, String displayName){
        mEmail = email;
        mDisplayName = displayName;
    }
}
