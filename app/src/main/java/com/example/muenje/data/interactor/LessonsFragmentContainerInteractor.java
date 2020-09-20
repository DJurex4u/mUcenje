package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.FullLesson;
import com.example.muenje.data.network.RxFirebaseRealtimeDatabaseRepositoryHelper;

import io.reactivex.Maybe;

public class LessonsFragmentContainerInteractor {
    RxFirebaseRealtimeDatabaseRepositoryHelper mDatabase;


    public LessonsFragmentContainerInteractor(RxFirebaseRealtimeDatabaseRepositoryHelper rxFirebaseRealtimeDatabaseRepositoryHelper){
        mDatabase = rxFirebaseRealtimeDatabaseRepositoryHelper;    }

    public Maybe<FullLesson> getFullLesson(Integer id){
        return mDatabase.getFullLesson(id);
    }

    public void setLessonReed(String username,String lessonId) {
        mDatabase.setLessonReed(username,lessonId);
    }
}
