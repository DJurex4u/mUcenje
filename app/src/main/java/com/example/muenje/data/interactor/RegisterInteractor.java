package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.User;
import com.example.muenje.data.network.RxFirebaseAuthHelper;

import io.reactivex.Maybe;

public class RegisterInteractor {

    RxFirebaseAuthHelper mRxFirebaseHelper;

    public RegisterInteractor(RxFirebaseAuthHelper rxFirebaseHelper) {
        mRxFirebaseHelper = rxFirebaseHelper;
    }

    public Maybe<User> createNewUser(String email, String password) {
        return mRxFirebaseHelper.createNewUser(email, password);
    }
}