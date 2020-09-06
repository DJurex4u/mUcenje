package com.example.muenje.data.network;

import com.example.muenje.data.entities.User;
import com.google.firebase.auth.AuthResult;
import com.example.muenje.utilities.mapper.IMapper;
import com.example.muenje.utilities.schedulers.AppSchedulerProvider;

import io.reactivex.Maybe;

public class RxFirebaseHelper {
    //poziva repo
    RxFirebaseRepository mRxFirebaseRepository;
    IMapper<AuthResult, User> mAuthResultToUserMapper;
    AppSchedulerProvider mAppSchedulerProvider;

    public RxFirebaseHelper(RxFirebaseRepository rxFirebaseRepository, IMapper<AuthResult, User> authResultToUserMapper,AppSchedulerProvider appSchedulerProvider) {
        mRxFirebaseRepository = rxFirebaseRepository;
        mAuthResultToUserMapper = authResultToUserMapper;
        mAppSchedulerProvider = appSchedulerProvider;
    }

    public Maybe<User> authenticateUser( String email, String password) {
        return mRxFirebaseRepository
                .authenticateUser(email, password)
                .subscribeOn(mAppSchedulerProvider.io())
                .map((authUser) -> mAuthResultToUserMapper.map(authUser))
                .observeOn(mAppSchedulerProvider.ui());
    }
    //ovdje map da mapiram

}
