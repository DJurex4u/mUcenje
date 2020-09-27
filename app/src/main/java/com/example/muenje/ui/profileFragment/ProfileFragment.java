package com.example.muenje.ui.profileFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.muenje.BaseApplication;
import com.example.muenje.core.RxNavigationFragment;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.ProfileInteractor;
import com.example.muenje.databinding.FragmentProfileBinding;
import com.example.muenje.routers.ProfileRouter;

public class ProfileFragment extends RxNavigationFragment {

    FragmentProfileBinding mBinding;
    ProfileViewModel mViewModel;
    ProfileRouter mRouter;
    ProfileInteractor mInteractor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(ProfileViewModel.class);
        User user = ProfileFragmentArgs.fromBundle(getArguments()).getUser();
        BaseApplication application = ((BaseApplication) requireActivity().getApplication());
        mInteractor = new ProfileInteractor(application.getRxFirebaseRealtimeDatabaseRepositoryHelper());
        mViewModel.setUpViewModel(user, mInteractor);
        mViewModel.initViewModel();
        connectViewModel();
        mRouter = new ProfileRouter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentProfileBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setViewModel(mViewModel);
        connectPointsEarned();
        connectUserTier();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.resetData(); 
    }

    private void connectViewModel() {
         addDisposableToCompositeDisposable(mViewModel.getNavigationObservable().subscribe((to) -> {
            switch (to) {
                case GO_TO_MISSIONS:
                    mRouter.navigateToMissions(mViewModel.getUser().getValue());
                    break;
                case GO_TO_ACHIEVEMENT:
                    mRouter.navigateToAchievements(mViewModel.getUser().getValue());
                    break;
                case GO_TO_LEADERBOARD:
                    mRouter.navigateToLeaderboard();
                    break;
            }
        }));

    }
    private void connectPointsEarned(){
        mViewModel.getPointsEarned().observe(getViewLifecycleOwner(), pointsEarned->{
            mBinding.profileHeader2PointsTextView.setText(pointsEarned);
        });
    }

    private void connectUserTier(){
        mViewModel.getUserTier().observe(getViewLifecycleOwner(),userTier->{
            mBinding.profileUserTierTextView.setText(userTier);
        });
    }
}