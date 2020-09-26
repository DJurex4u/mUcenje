package com.example.muenje.ui.leaderboardFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.Leaderboard;
import com.example.muenje.data.interactor.LeaderboardInteractor;

public class LeaderboardViewModel extends RxViewModel {

    private LeaderboardInteractor mInteractor;

    private MutableLiveData<Leaderboard> mLeaderboard = new MutableLiveData<>();

    void setUpViewModel(LeaderboardInteractor interactor) {
        mInteractor = interactor;
    }

    void initViewModel() {
        getCompositeDisposable().add(mInteractor.getLeaderboard().subscribe((leaderboard -> mLeaderboard.postValue(leaderboard)), (error) -> {

        }));
    }

    public LiveData<Leaderboard> getLeaderboard() {
        return mLeaderboard;
    }
}
