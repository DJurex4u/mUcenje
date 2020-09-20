package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.User;
import com.example.muenje.data.network.RxFirebaseAuthHelper;

import io.reactivex.Maybe;

public class LoginInteractor {
    RxFirebaseAuthHelper mRxFirebaseHelper;
    public LoginInteractor(RxFirebaseAuthHelper rxFirebaseHelper){
        mRxFirebaseHelper = rxFirebaseHelper;
    }

    public Maybe<User> authenticateUser(String email,String password){
        return mRxFirebaseHelper.authenticateUser(email,password);
    }

}
