package com.example.muenje.data.network;

import com.example.muenje.data.entities.User;
import com.example.muenje.utilities.mapper.IMapper;
import com.example.muenje.utilities.schedulers.AppSchedulerProvider;
import com.google.firebase.auth.AuthResult;

import io.reactivex.Maybe;

public class RxFirebaseAuthHelper {

    RxFirebaseAuthRepository mRxFirebaseRepository;
    IMapper<AuthResult, User> mAuthResultToUserMapper;
    AppSchedulerProvider mAppSchedulerProvider;

    public RxFirebaseAuthHelper(RxFirebaseAuthRepository rxFirebaseRepository, IMapper<AuthResult, User> authResultToUserMapper, AppSchedulerProvider appSchedulerProvider) {
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

    public Maybe<User> createNewUser(String email, String password){
        return mRxFirebaseRepository
                .createUser(email, password)
                .subscribeOn(mAppSchedulerProvider.io())
                .map((createdUser)->mAuthResultToUserMapper.map(createdUser))
                .observeOn(mAppSchedulerProvider.ui());
    }

}
