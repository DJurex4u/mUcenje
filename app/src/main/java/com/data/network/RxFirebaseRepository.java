package com.data.network;

import com.BaseApplication;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import durdinapps.rxfirebase2.RxFirebaseAuth;
import io.reactivex.Maybe;

public class RxFirebaseRepository {
    FirebaseAuth mAuth;
    public RxFirebaseRepository(FirebaseAuth auth){
        mAuth = auth;
    }

    Maybe<AuthResult> authenticateUser(@NotNull String email, @NotNull String password){
        return RxFirebaseAuth.signInWithEmailAndPassword(mAuth, email, password);
    }

}
