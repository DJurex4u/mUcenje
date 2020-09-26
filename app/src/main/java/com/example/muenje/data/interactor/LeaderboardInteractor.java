package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.Leaderboard;
import com.example.muenje.data.network.RxFirebaseRealtimeDatabaseRepositoryHelper;

import io.reactivex.Maybe;

public class LeaderboardInteractor {
    private final RxFirebaseRealtimeDatabaseRepositoryHelper mDatabase;


    public LeaderboardInteractor(RxFirebaseRealtimeDatabaseRepositoryHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    public Maybe<Leaderboard> getLeaderboard(){
        return mDatabase.getLeaderBoard();
    }
}
