package com.example.muenje.ui.achievementsFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muenje.BaseApplication;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.AchievementsInteractor;
import com.example.muenje.databinding.FragmentAchievementsBinding;

public class AchievementsFragment extends Fragment {

    FragmentAchievementsBinding mBinding;
    AchievementsViewModel mViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BaseApplication application = ((BaseApplication) requireActivity().getApplication());
        mViewModel = new ViewModelProvider(requireActivity()).get(AchievementsViewModel.class);
        AchievementsInteractor achievementsInteractor = new AchievementsInteractor(application.getRxFirebaseRealtimeDatabaseRepositoryHelper());
        User user = AchievementsFragmentArgs.fromBundle(getArguments()).getUser();
        mViewModel.setUpViewModel(achievementsInteractor,user);
        mViewModel.initViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentAchievementsBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        connectViewModel();
    }

    void connectViewModel(){
        mViewModel.getSingleAchievementList().observe(getViewLifecycleOwner(),(singleAchievements -> { }));
    }
}