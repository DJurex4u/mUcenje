package com.example.muenje.ui.achievementsFragment;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.SingleAchievement;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.AchievementsInteractor;

import java.util.ArrayList;
import java.util.List;

public class AchievementsViewModel extends RxViewModel {

    private AchievementsInteractor mIntereactor;
    private User mUser;

    private MutableLiveData<List<SingleAchievement>> mSingleAchievementList = new MutableLiveData<>();

    void setUpViewModel(AchievementsInteractor interactor, User user) {
        mIntereactor = interactor;
        mUser = user;
    }

    void initViewModel() {
        getCompositeDisposable().add(mIntereactor.getUsersAchievement(mUser).subscribe(
                singleAchievements -> mSingleAchievementList.setValue(singleAchievements)
        ));
    }

    public LiveData<List<SingleAchievement>> getSingleAchievementList() {
        return Transformations.map(mSingleAchievementList,filterNotAchievedAchievements);
    }

    private Function<List<SingleAchievement>,List<SingleAchievement>> filterNotAchievedAchievements = (notFilteredList) -> {
        ArrayList<SingleAchievement> filteredList = new ArrayList<>();
        for (SingleAchievement singleAchievement : notFilteredList){
            if (singleAchievement.isAchieved){
                filteredList.add(singleAchievement);
            }
        }
        return filteredList;
    };
}
