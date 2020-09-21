package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.SingleAchievement;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.network.RxFirebaseRealtimeDatabaseRepositoryHelper;

import java.util.List;

import io.reactivex.Maybe;

public class AchievementsInteractor {
    private final RxFirebaseRealtimeDatabaseRepositoryHelper mDatabase;

    public AchievementsInteractor(RxFirebaseRealtimeDatabaseRepositoryHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    public Maybe<List<SingleAchievement>> getUsersAchievement(User user){
        return mDatabase.getUserAchievements(user);
    }
}
