package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.User;
import com.example.muenje.data.network.RxFirebaseAuthHelper;

import io.reactivex.Maybe;

public class LoginInteractor {
    //zove helper
    //zvan je u ViewModelu (određene metode daje viewModelu da što je odradio)
    //vezan za to što ViewModelu treba
    //radim map zbog use casea
    RxFirebaseAuthHelper mRxFirebaseHelper;
    public LoginInteractor(RxFirebaseAuthHelper rxFirebaseHelper){
        mRxFirebaseHelper = rxFirebaseHelper;
    }

    public Maybe<User> authenticateUser(String email,String password){
        return mRxFirebaseHelper.authenticateUser(email,password);
    }

}
