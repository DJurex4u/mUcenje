package com.example.muenje;

import android.app.Application;

import com.example.muenje.data.network.RxFirebaseHelper;
import com.example.muenje.data.network.RxFirebaseRepository;
import com.example.muenje.utilities.mapper.AuthResultToUserMapper;
import com.example.muenje.utilities.schedulers.AppSchedulerProvider;
import com.google.firebase.auth.FirebaseAuth;

public class BaseApplication extends Application {
    //will create only one instance of:
    private FirebaseAuth mAuth;
    private RxFirebaseRepository mRxFirebaseRepository;
    private RxFirebaseHelper mRxFirebaseHelper;
    private AppSchedulerProvider mAppSchedulerProvider = new AppSchedulerProvider();

    @Override
    public void onCreate() {
        mAuth = FirebaseAuth.getInstance();
        mRxFirebaseRepository = new RxFirebaseRepository(mAuth);
        mRxFirebaseHelper = new RxFirebaseHelper(mRxFirebaseRepository, new AuthResultToUserMapper(),mAppSchedulerProvider);
        super.onCreate();
    }

    public RxFirebaseHelper getRxFirebaseHelperInstance(){
        return mRxFirebaseHelper;
    }
}
