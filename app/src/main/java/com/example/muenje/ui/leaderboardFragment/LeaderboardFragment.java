package com.example.muenje.ui.leaderboardFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muenje.BaseApplication;
import com.example.muenje.adapters.LeaderboardEntryAdapter;
import com.example.muenje.data.interactor.LeaderboardInteractor;
import com.example.muenje.databinding.FragmentLeaderboardBinding;


public class LeaderboardFragment extends Fragment {

    FragmentLeaderboardBinding mBinding;
    LeaderboardViewModel mViewModel;
    LeaderboardEntryAdapter mAdapter = new LeaderboardEntryAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication application = ((BaseApplication) requireActivity().getApplication());
        LeaderboardInteractor interactor = new LeaderboardInteractor(application.getRxFirebaseRealtimeDatabaseRepositoryHelper());
        mViewModel = new ViewModelProvider(this).get(LeaderboardViewModel.class);
        mViewModel.setUpViewModel(interactor);
        mViewModel.initViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentLeaderboardBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecycleView();
        connectViewModel();
    }

    void connectViewModel(){
        mViewModel.getLeaderboard().observe(getViewLifecycleOwner(),(leaderboard -> mAdapter.setData(leaderboard.getOrderedListDescending())));
    }

    void setUpRecycleView(){
        mBinding.achievementsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.achievementsRecyclerView.setAdapter(mAdapter);
    }
}