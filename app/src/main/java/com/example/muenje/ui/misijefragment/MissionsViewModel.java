package com.example.muenje.ui.misijefragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jakewharton.rxrelay3.PublishRelay;

import io.reactivex.rxjava3.core.Observable;

public class MissionsViewModel extends ViewModel {

    public enum GoTo {
        GO_TO_LECTIONS,
        GO_TO_CHALLENGES
    }
    private PublishRelay<GoTo> mNavigateTo = PublishRelay.create();
    public Observable<GoTo> getNavigateTo() {
        return mNavigateTo;
    }

    public void goToLectionsFragment(){
        mNavigateTo.accept(MissionsViewModel.GoTo.GO_TO_LECTIONS);
    }

    public void goToChallengesFragment(){
        mNavigateTo.accept(MissionsViewModel.GoTo.GO_TO_CHALLENGES);
    }
}
