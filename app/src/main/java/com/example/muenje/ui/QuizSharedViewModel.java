package com.example.muenje.ui;

import androidx.lifecycle.ViewModel;

import com.example.muenje.utilities.AnswerChecker;
import com.jakewharton.rxrelay3.PublishRelay;

import io.reactivex.rxjava3.core.Observable;

public class QuizSharedViewModel extends ViewModel {

    AnswerChecker mAnswerChecker;

    PublishRelay<Boolean> userAnswerCorrect = PublishRelay.create();

    private Boolean isInASingeShot = true;

    public void setUpViewModel(AnswerChecker answerChecker){
        mAnswerChecker = answerChecker;
    }

    public void putInAnswer(String answer,Integer position){
        Boolean isCorrectAnswer = mAnswerChecker.checkAnswer(answer,position);
        if(!isCorrectAnswer && isInASingeShot){
            isInASingeShot = false;
        }
        userAnswerCorrect.accept(isCorrectAnswer);
    }

    public Observable<Boolean> getUserAnswerCorrect(){
        return userAnswerCorrect;
    }

    public Boolean getIsInASingeShot() {
        return isInASingeShot;
    }
}
