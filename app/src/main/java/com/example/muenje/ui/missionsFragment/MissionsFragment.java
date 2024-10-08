package com.example.muenje.ui.missionsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.muenje.core.RxNavigationFragment;
import com.example.muenje.data.entities.User;
import com.example.muenje.databinding.FragmentMissionsBinding;
import com.example.muenje.routers.MissionsRouter;


public class MissionsFragment extends RxNavigationFragment {

    FragmentMissionsBinding mBinding;
    MissionsViewModel mViewModel;
    MissionsRouter mRouter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MissionsFragmentArgs args = MissionsFragmentArgs.fromBundle(getArguments());
        mViewModel = new ViewModelProvider(requireActivity()).get(MissionsViewModel.class);
        User user = args.getUser();
        mViewModel.initViewModel(user);
        connectViewModel();
        mRouter = new MissionsRouter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentMissionsBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setViewModel(mViewModel);
    }

    private void connectViewModel(){
        addDisposableToCompositeDisposable(mViewModel.getNavigateTo().subscribe((to)->{
            switch (to){
                case GO_TO_LESSONS:
                    mRouter.navigateToLessons(mViewModel.getUser());
                    break;
                case GO_TO_CHALLENGES:
                    mRouter.navigateToChallenges(mViewModel.getUser());
                    break;
            }
        }));
    }
}