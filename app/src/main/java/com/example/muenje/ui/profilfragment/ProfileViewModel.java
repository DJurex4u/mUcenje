package com.example.muenje.ui.profilfragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.muenje.data.entities.User;
import com.jakewharton.rxrelay3.PublishRelay;

import io.reactivex.rxjava3.core.Observable;


public class ProfileViewModel extends ViewModel{

    public enum GoTo {
        GO_TO_ACHIEVEMENT,
        GO_TO_MISSIONS
    }

    private PublishRelay<GoTo> mNavigateTo = PublishRelay.create();
    public MutableLiveData<User> mUser = new MutableLiveData<>();

    public void goToAchievementsFragment(){
        mNavigateTo.accept(GoTo.GO_TO_ACHIEVEMENT);
    }

    public void goToMissionsFragment(){
        mNavigateTo.accept(GoTo.GO_TO_MISSIONS);
    }

    public Observable<GoTo> getNavigationObservable(){
        return mNavigateTo;
    }

}
