package com.example.muenje.ui.quizzesContainerFragment;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.FullQuiz;
import com.example.muenje.data.entities.QuestionSet;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.QuizzesContainerInteractor;
import com.jakewharton.rxrelay3.PublishRelay;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;


public class QuizzesContainerViewModel extends RxViewModel {

    public enum GoTo{
        GO_BACK
    }

    QuizzesContainerInteractor mInteractor;
    Integer mQuizId;
    private PublishRelay<QuizzesContainerViewModel.GoTo> mNavigateTo = PublishRelay.create();
    MutableLiveData<FullQuiz> mFullQuiz = new MutableLiveData<>();
    User mUser;

    void setUpViewModel(QuizzesContainerInteractor quizzesContainerInteractor, Integer quizId, User user){
        mInteractor = quizzesContainerInteractor;
        mQuizId = quizId;
        mUser = user;
    }

    void initViewModel(){
        getCompositeDisposable().add(mInteractor.getFullQuiz(mQuizId).subscribe(fullQuiz-> mFullQuiz.setValue(fullQuiz)));
    }

    public Observable<GoTo> getNavigationObservable(){ return mNavigateTo;}

    public void goBack(){
        mInteractor.setQuizSolved(mUser,mQuizId);
        mNavigateTo.accept(GoTo.GO_BACK);
    }

    public LiveData<FullQuiz> getFullQuiz(){
        return mFullQuiz;
    }

    public LiveData<List<String>> getCorrectAnswers(){
        return Transformations.map(mFullQuiz, new Function<FullQuiz, List<String>>() {
            @Override
            public List<String> apply(FullQuiz input) {
                ArrayList<String> correctAnswers = new ArrayList<>();
                for (QuestionSet questionSet : input.questionSet){
                    correctAnswers.add(questionSet.correctAnswers);
                }
                return correctAnswers;
            }
        });
    }

    public void quizSolved(Boolean isInASingleShot){
        if (isInASingleShot){
            mInteractor.setQuizSolved(mUser,mQuizId);
        }
        mNavigateTo.accept(GoTo.GO_BACK); 
    }
}
