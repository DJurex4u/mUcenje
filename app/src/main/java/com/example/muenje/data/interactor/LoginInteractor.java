package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.User;
import com.example.muenje.data.network.RxFirebaseHelper;

import io.reactivex.Maybe;

public class LoginInteractor {
    //zove helper
    //daje ViewMOdelu određene metode i daje viewModelu da što je odradio nad UseCaseovima
    //vezan za to što ViewModelu treba
    //radim map zbog use casea
    RxFirebaseHelper mRxFirebaseHelper;
    public LoginInteractor(RxFirebaseHelper rxFirebaseHelper){
        mRxFirebaseHelper = rxFirebaseHelper;
    }

    public Maybe<User> authenticateUser(String email,String password){
        return mRxFirebaseHelper.authenticateUser(email,password);
    }

}
