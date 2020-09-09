package com.example.muenje.ui.misijefragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MissionsViewModel extends ViewModel {

    public enum ClickedChoice{
        GO_TO_LECTIONS,
        GO_TO_CHALLENGES
    }

    private MutableLiveData<MissionsViewModel.ClickedChoice> mClickedChoice = new MutableLiveData<>();

    public MutableLiveData<MissionsViewModel.ClickedChoice> getClickedChoice() {
        return mClickedChoice;
    }

    public void goToLectionsFragment(){
        mClickedChoice.setValue(ClickedChoice.GO_TO_LECTIONS);
    }

    public void goToChallengesFragment(){
        mClickedChoice.setValue(ClickedChoice.GO_TO_CHALLENGES);
    }
}
