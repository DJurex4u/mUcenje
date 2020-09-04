package com.data.network;

import com.BaseApplication;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import durdinapps.rxfirebase2.RxFirebaseAuth;

public class RxFirebaseRepository {
    FirebaseAuth mAuth;
    public RxFirebaseRepository(FirebaseAuth auth){
        mAuth = auth;
    }

    void authenticateUser(@NotNull String email, @NotNull String password){
        RxFirebaseAuth.signInWithEmailAndPassword(mAuth, email, password);
    }

}
