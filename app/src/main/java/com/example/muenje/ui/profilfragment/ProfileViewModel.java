package com.example.muenje.ui.profilfragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.muenje.data.entities.User;

public class ProfileViewModel extends ViewModel {

    public enum ClickedChoice{
        GO_TO_ACHIEVEMENT,
        GO_TO_MISSIONS
    }

    public MutableLiveData<User> mUser = new MutableLiveData<>();
    private MutableLiveData<ClickedChoice> mClickedChoice = new MutableLiveData<>();

    public LiveData<ClickedChoice> getClickedChoice(){return mClickedChoice;}

    public void goToAchievementsFragment(){
        mClickedChoice.setValue(ClickedChoice.GO_TO_ACHIEVEMENT);
    }

    public void goToMissionsFragment(){
        mClickedChoice.setValue(ClickedChoice.GO_TO_MISSIONS);
    }
}
