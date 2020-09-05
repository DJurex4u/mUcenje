package com;

import android.app.Application;

import com.data.network.RxFirebaseHelper;
import com.data.network.RxFirebaseRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.utilities.mapper.AuthResultToUserMapper;
import com.utilities.mapper.IMapper;

public class BaseApplication extends Application {
    //will create only one instance of:
    private FirebaseAuth mAuth;
    private RxFirebaseRepository mRxFirebaseRepository;
    private RxFirebaseHelper mRxFirebaseHelper;

    @Override
    public void onCreate() {
        mAuth = FirebaseAuth.getInstance();
        mRxFirebaseRepository = new RxFirebaseRepository(mAuth);
        mRxFirebaseHelper = new RxFirebaseHelper(mRxFirebaseRepository, new AuthResultToUserMapper());
        super.onCreate();
    }

    public RxFirebaseHelper getRxFirebaseHelperInstance(){
        return mRxFirebaseHelper;
    }
}
