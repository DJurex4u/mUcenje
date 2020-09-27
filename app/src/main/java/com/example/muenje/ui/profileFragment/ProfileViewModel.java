package com.example.muenje.ui.profileFragment;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.SingleAchievement;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.ProfileInteractor;
import com.jakewharton.rxrelay3.PublishRelay;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;


public class ProfileViewModel extends RxViewModel {

    public enum GoTo {
        GO_TO_ACHIEVEMENT,
        GO_TO_MISSIONS,
        GO_TO_LEADERBOARD
    }

    private ProfileInteractor mInteractor;
    private PublishRelay<GoTo> mNavigateTo = PublishRelay.create();
    private MutableLiveData<User> mUser = new MutableLiveData<>();
    private MutableLiveData<List<SingleAchievement>> mAchievements = new MutableLiveData<>();
    private MutableLiveData<String> mPointsEarned = new MutableLiveData<>();
    private MutableLiveData<String> mUserTier = new MutableLiveData<>();

    void setUpViewModel(User user, ProfileInteractor interactor) {
        mUser.setValue(user);
        mInteractor = interactor;
    }

    void initViewModel() {
        getCompositeDisposable().add(mInteractor.getUsersAchievement(mUser.getValue()).subscribe(
                (singleAchievementsList) -> {
                    mAchievements.setValue(singleAchievementsList);
                }));

        mPointsEarned = (MutableLiveData) Transformations.map(mAchievements, mapAchievementsToPoints);
        mUserTier = (MutableLiveData) Transformations.map(mPointsEarned, mapPointsEarnedToUserTier);
    }

    public void goToAchievementsFragment() {
        mNavigateTo.accept(GoTo.GO_TO_ACHIEVEMENT);
    }

    public void goToMissionsFragment() {
        mNavigateTo.accept(GoTo.GO_TO_MISSIONS);
    }

    public void goToLeaderboardFragment(){mNavigateTo.accept(GoTo.GO_TO_LEADERBOARD);}

    public Observable<GoTo> getNavigationObservable(){
        return mNavigateTo;
    }

    public LiveData<User> getUser() {
        return mUser;
    }


    public MutableLiveData<String> getPointsEarned() {
        return mPointsEarned;
    }

    public MutableLiveData<String> getUserTier() {
        return mUserTier;
    }

    Function<List<SingleAchievement>, String> mapAchievementsToPoints = new Function<List<SingleAchievement>, String>() {
        @Override
        public String apply(List<SingleAchievement> input) {
            return calculatePointsEarned().toString();
        }
    };

    Function<String,String> mapPointsEarnedToUserTier = new Function<String, String>(){
        @Override
        public String apply(String input) {
            return getUserTierString(Integer.valueOf(input));
        }
    };

    public Integer calculatePointsEarned() {
        Integer numberOfAchieved = 0;
        for (SingleAchievement achievement : mAchievements.getValue()
        ) {
            if (achievement.isAchieved) {
                numberOfAchieved++;
            }
        }
        return numberOfAchieved * 5;
    }

    public void resetData() {
        getCompositeDisposable().add(mInteractor.getUsersAchievement(mUser.getValue()).subscribe(
                (singleAchievementsList) -> {
                    mAchievements.setValue(singleAchievementsList);
                }));
    }

    private String getUserTierString(Integer pointsEarned){
        Integer oldValue = pointsEarned;
        Integer oldMin = 0;
        Integer oldMax = 30;
        Integer newMax = 4;
        Integer newMin = 0;
        Integer newValue = (((oldValue - oldMin) * (newMax - newMin)) / (oldMax - oldMin)) + newMin;
        return UserTierNotes.getTierDisplayName(newValue);
    }

    static class UserTierNotes {
        private final static ArrayList<String> tierDisplayNames = new ArrayList<String>() {
            { 
                add("POČETNIK");
                add("ŽELJAN ZNANJA");
                add("MARLJIV");
                add("ISKUSAN");
                add("UČENJAK");
            }
        };

        public static String getTierDisplayName(Integer id) {
            return tierDisplayNames.get(id);
        }
    }
}
