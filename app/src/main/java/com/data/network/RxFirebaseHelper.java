package com.data.network;

import com.data.entities.User;
import com.google.firebase.auth.AuthResult;
import com.utilities.mapper.IMapper;
import com.utilities.schedulers.AppSchedulerProvider;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;

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

    public Maybe<User> authenticateUser(@NotNull String email, @NotNull String password) {
        return mRxFirebaseRepository
                .authenticateUser(email, password)
                .subscribeOn(mAppSchedulerProvider.io())
                .map((authUser) -> mAuthResultToUserMapper.map(authUser))
                .observeOn(mAppSchedulerProvider.ui());
    }
    //ovdje map da mapiram

}
