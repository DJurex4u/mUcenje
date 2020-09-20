package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.FullQuiz;
import com.example.muenje.data.entities.QuestionSet;
import com.example.muenje.data.network.RxFirebaseRealtimeDatabaseRepositoryHelper;

import io.reactivex.Maybe;

public class ChallengesContainerInteractor {
    RxFirebaseRealtimeDatabaseRepositoryHelper mDatabase;

    public ChallengesContainerInteractor(RxFirebaseRealtimeDatabaseRepositoryHelper database) {
        mDatabase = database;
    }

   public Maybe<FullQuiz> getFullQuiz(Integer id){
        return mDatabase.getFullQuiz(id);
   }
   public void setQuizSuccessfullyFinished(String username, String quizId){
    //TODO: call mDatabase method with given parameters
    }
}
