package com.example.muenje;

import android.app.Application;

import com.example.muenje.data.network.RxFirebaseAuthHelper;
import com.example.muenje.data.network.RxFirebaseAuthRepository;
import com.example.muenje.utilities.mapper.AuthResultToUserMapper;
import com.example.muenje.utilities.schedulers.AppSchedulerProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseApplication extends Application {
    //will create only one instance of:
    private FirebaseAuth mAuth;
    private RxFirebaseAuthRepository mRxFirebaseRepository;
    private RxFirebaseAuthHelper mRxFirebaseHelper;
    private AppSchedulerProvider mAppSchedulerProvider = new AppSchedulerProvider();
    private FirebaseDatabase mFirebaseDatabase;

    @Override
    public void onCreate() {
        mAuth = FirebaseAuth.getInstance();
        mRxFirebaseRepository = new RxFirebaseAuthRepository(mAuth);
        mRxFirebaseHelper = new RxFirebaseAuthHelper(mRxFirebaseRepository, new AuthResultToUserMapper(),mAppSchedulerProvider);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        super.onCreate();
    }

    public RxFirebaseAuthHelper getRxFirebaseHelperInstance(){
        return mRxFirebaseHelper;
    }
}
