package com;

import android.app.Application;

import com.data.network.RxFirebaseRepository;
import com.google.firebase.auth.FirebaseAuth;

public class BaseApplication extends Application {
    //will create only one instance of:
    private FirebaseAuth mAuth;
    private RxFirebaseRepository mRepo;

    @Override
    public void onCreate() {
        mAuth = FirebaseAuth.getInstance();
        mRepo = new RxFirebaseRepository(mAuth);
        super.onCreate();
    }

    public RxFirebaseRepository getRepoInstance(){
        return mRepo;
    }
}
