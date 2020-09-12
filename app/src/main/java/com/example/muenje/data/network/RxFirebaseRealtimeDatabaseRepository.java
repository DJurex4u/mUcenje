package com.example.muenje.data.network;

import com.example.muenje.data.network.pojo.LectionTitleResponse;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Maybe;

public class RxFirebaseRealtimeDatabaseRepository {

    FirebaseDatabase mFirebaseDatabase;

    public RxFirebaseRealtimeDatabaseRepository(FirebaseDatabase firebaseDatabase) {
        mFirebaseDatabase = firebaseDatabase;
    }

    public Maybe<List<LectionTitleResponse>> getLectionTitles() {
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getLectionTitleReference());
        return RxFirebaseDatabase.observeSingleValueEvent(query,
                (dataSnapshot -> {
                    ArrayList<LectionTitleResponse> lectionsTitlesArrayList = new ArrayList<>();
                    for (DataSnapshot dataSnapshotLectionTitles : dataSnapshot.getChildren()) {
                        lectionsTitlesArrayList.add(dataSnapshotLectionTitles.getValue(LectionTitleResponse.class));
                    }
                    return lectionsTitlesArrayList;
                }));
    }

    private static class referenceNotes {
        final static String challenges = "challenges";
        final static String lections = "lections";
        final static String titles = "titles";

        public static String getLectionTitleReference() {
            return referenceNotes.challenges + "/" + referenceNotes.lections + "/" + referenceNotes.titles;
        }
    }
}
