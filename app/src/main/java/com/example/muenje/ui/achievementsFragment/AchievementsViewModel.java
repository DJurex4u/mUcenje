package com.example.muenje.ui.achievementsFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.SingleAchievement;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.AchievementsInteractor;

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
                singleAchievements -> mSingleAchievementList.setValue(singleAchievements),
                (error) -> {
                    Integer i = 5;
                    i--;
                }, () -> {
                    Integer i = 5;
                    i--;
                }));
    }

    LiveData<List<SingleAchievement>> getSingleAchievementList() {
        return mSingleAchievementList;
    }
}
