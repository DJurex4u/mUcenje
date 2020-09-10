package com.example.muenje.ui.misijefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.muenje.databinding.FragmentMisijeBinding;
import com.example.muenje.routers.MissionsRouter;


public class MissionsFragment extends Fragment {

    FragmentMisijeBinding mBinding;
    MissionsViewModel mViewModel;
    MissionsRouter mRouter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(MissionsViewModel.class);
        connectViewModel();
        mRouter = new MissionsRouter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentMisijeBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setViewModel(mViewModel);
    }

    private void connectViewModel(){
        mViewModel.getClickedChoice().observe(this,(to)->{
            switch (to){
                case GO_TO_LECTIONS:
                    mRouter.navigateToLections();
                    break;
                case GO_TO_CHALLENGES:
                    mRouter.navigateToChallenges();
                    break;
            }
        });
    }
}