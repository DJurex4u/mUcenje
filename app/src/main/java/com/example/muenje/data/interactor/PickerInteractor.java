package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.Title;
import com.example.muenje.data.network.RxFirebaseRealtimeDatabaseRepositoryHelper;

import java.util.List;

import io.reactivex.Maybe;

public class PickerInteractor {

    final RxFirebaseRealtimeDatabaseRepositoryHelper mDatabase;

    public PickerInteractor(RxFirebaseRealtimeDatabaseRepositoryHelper rxFirebaseRealtimeDatabaseRepositoryHelper){
        mDatabase = rxFirebaseRealtimeDatabaseRepositoryHelper;
    }

    public Maybe<List<Title>> getLessonsTitles(){
        return mDatabase.getLessonsTitles();
    }

    public Maybe<List<Title>> getQuizzesTitles(){
        return mDatabase.getQuizTitles();
    }
}
