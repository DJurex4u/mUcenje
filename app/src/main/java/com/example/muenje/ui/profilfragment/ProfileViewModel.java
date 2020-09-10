package com.example.muenje.ui.profilfragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.muenje.data.entities.User;
import com.jakewharton.rxrelay3.PublishRelay;

import io.reactivex.rxjava3.core.Observable;


public class ProfileViewModel extends ViewModel{

    private PublishRelay<ClickedChoice> mRelay = PublishRelay.create();

    public enum ClickedChoice{
        GO_TO_ACHIEVEMENT,
        GO_TO_MISSIONS
    }

    public MutableLiveData<User> mUser = new MutableLiveData<>();

    public void goToAchievementsFragment(){
        mRelay.accept(ClickedChoice.GO_TO_ACHIEVEMENT);
    }

    public void goToMissionsFragment(){
        mRelay.accept(ClickedChoice.GO_TO_MISSIONS);
    }

    public Observable<ClickedChoice> getNavigationObservable(){
        return mRelay;
    }

}
