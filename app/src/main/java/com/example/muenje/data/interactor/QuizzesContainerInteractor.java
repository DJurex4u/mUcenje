package com.example.muenje.data.interactor;

import com.example.muenje.data.entities.FullQuiz;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.network.RxFirebaseRealtimeDatabaseRepositoryHelper;

import io.reactivex.Maybe;

public class QuizzesContainerInteractor {

    final RxFirebaseRealtimeDatabaseRepositoryHelper mRxFirebaseRealtimeDatabaseRepositoryHelper;

    public QuizzesContainerInteractor(RxFirebaseRealtimeDatabaseRepositoryHelper rxFirebaseRealtimeDatabaseRepositoryHelper) {
        mRxFirebaseRealtimeDatabaseRepositoryHelper = rxFirebaseRealtimeDatabaseRepositoryHelper;
    }

    public Maybe<FullQuiz> getFullQuiz(Integer quizId){
        return mRxFirebaseRealtimeDatabaseRepositoryHelper.getFullQuiz(quizId);
    }

    public void setQuizSolved(User user, Integer quizId){
        mRxFirebaseRealtimeDatabaseRepositoryHelper.setQuizSolved(user.mDisplayName,quizId.toString());
    }
}
