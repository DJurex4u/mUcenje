package com.example.muenje.data.network;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RxFirebaseRealtimeDatabaseRepository {

    FirebaseDatabase mFirebaseDatabase;

    public RxFirebaseRealtimeDatabaseRepository(FirebaseDatabase firebaseDatabase){
        mFirebaseDatabase = firebaseDatabase;
    }

}
