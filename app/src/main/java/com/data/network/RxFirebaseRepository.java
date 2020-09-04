package com.data.network;

import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import durdinapps.rxfirebase2.RxFirebaseAuth;

public class RxFirebaseRepository {


    void authenticateUser(@NotNull String email, @NotNull String password){

        RxFirebaseAuth.signInWithEmailAndPassword(auth, email, password)
                .map(authResult -> authResult.getUser() != null)
                .take(1)
                .subscribe(logged -> {
                    Log.i("Rxfirebase2", "User logged " + logged);
                });
    }

}
