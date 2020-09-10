package com.example.muenje.data.network;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import durdinapps.rxfirebase2.RxFirebaseAuth;
import io.reactivex.Maybe;

public class RxFirebaseRepository {
    FirebaseAuth mAuth;
    public RxFirebaseRepository(FirebaseAuth auth){
        mAuth = auth;
    }

    Maybe<AuthResult> authenticateUser( String email,String password){
        return RxFirebaseAuth.signInWithEmailAndPassword(mAuth, email, password);
    }

}
