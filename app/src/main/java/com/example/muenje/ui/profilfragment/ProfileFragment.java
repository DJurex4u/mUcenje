package com.example.muenje.ui.profilfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muenje.R;
import com.example.muenje.data.entities.User;
import com.example.muenje.databinding.FragmentProfilBinding;
import com.example.muenje.routers.ProfileRouter;
import com.example.muenje.ui.loginfragment.LoginViewModel;

public class ProfileFragment extends Fragment {

    FragmentProfilBinding mBinding;
    ProfileViewModel mViewModel;
    ProfileRouter mRouter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(ProfileViewModel.class);
        User user = ProfileFragmentArgs.fromBundle(getArguments()).getUser();
        connectViewModel(user);
        mRouter = new ProfileRouter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentProfilBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setViewModel(mViewModel);
    }

    private void connectViewModel(User user) {
        mViewModel.mUser.setValue(user);
        mViewModel.getClickedChoice().observe(this, (to) -> {
            switch (to) {
                case GO_TO_MISSIONS:
                    mRouter.navigateToMissions();
                    break;
                case GO_TO_ACHIEVEMENT:
                    mRouter.navigateToAchievements();
                    break;
            }
        });
    }
}