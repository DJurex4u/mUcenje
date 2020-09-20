package com.example.muenje.ui.quizzescontainerfragment;

import androidx.lifecycle.MutableLiveData;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.FullQuiz;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.ChallengesContainerInteractor;
import com.jakewharton.rxrelay3.PublishRelay;

import io.reactivex.rxjava3.core.Observable;


public class QuizzesContainerViewModel extends RxViewModel {

    public enum GoTo{
        GO_BACK
    }

    ChallengesContainerInteractor mInteractor;
    Integer mQuizId;
    private PublishRelay<QuizzesContainerViewModel.GoTo> mNavigateTo = PublishRelay.create();
    MutableLiveData<FullQuiz> mFullQuiz = new MutableLiveData<>();
    User mUser;

    void setUpViewModel(ChallengesContainerInteractor challengesContainerInteractor, Integer quizId, User user){
        getCompositeDisposable().add(mInteractor.getFullQuiz(mQuizId).subscribe(fullQuiz-> mFullQuiz.setValue(fullQuiz)));
    }

    public Observable<GoTo> getNavigationObservable(){ return mNavigateTo;}

    public void GoBack(){
        mInteractor.setQuizSuccessfullyFinished(mUser.mDisplayName,mQuizId.toString());
        mNavigateTo.accept(GoTo.GO_BACK);
    }

}
