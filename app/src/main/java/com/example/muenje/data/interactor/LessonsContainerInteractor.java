package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.FullLesson;
import com.example.muenje.data.network.RxFirebaseRealtimeDatabaseRepositoryHelper;

import io.reactivex.Maybe;

public class LessonsContainerInteractor {
    RxFirebaseRealtimeDatabaseRepositoryHelper mDatabase;


    public LessonsContainerInteractor(RxFirebaseRealtimeDatabaseRepositoryHelper database){
        mDatabase = database;    }

    public Maybe<FullLesson> getFullLesson(Integer id){
        return mDatabase.getFullLesson(id);
    }

    public void setLessonReed(String username,String lessonId) {
        mDatabase.setLessonReed(username,lessonId);
    }
}
