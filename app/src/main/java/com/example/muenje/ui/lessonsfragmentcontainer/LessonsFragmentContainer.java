package com.example.muenje.ui.lessonsfragmentcontainer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.muenje.BaseApplication;
import com.example.muenje.adapters.LessonsContainerPagerAdapter;
import com.example.muenje.data.interactor.LessonsFragmentContainerInteractor;
import com.example.muenje.databinding.FragmentLekcijaContainerBinding;

public class LessonsFragmentContainer extends Fragment {
    LessonsContainerPagerAdapter mLessonPagerAdapter;
    FragmentLekcijaContainerBinding mBinding;
    LessonsFragmentContainerViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLessonPagerAdapter = new LessonsContainerPagerAdapter(this);
        mViewModel = new ViewModelProvider(requireActivity()).get(LessonsFragmentContainerViewModel.class);
        Integer lessonId = LekcijaFragmentContainerArgs.fromBundle(getArguments()).getLesionId();
        BaseApplication application = ((BaseApplication) requireActivity().getApplication());
        LessonsFragmentContainerInteractor interactor = new LessonsFragmentContainerInteractor(application.getRxFirebaseRealtimeDatabaseRepositoryHelper());
        mViewModel.setUpViewModel(interactor,lessonId);
        mViewModel.initViewModel();
   }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentLekcijaContainerBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.viewPager2.setAdapter(mLessonPagerAdapter);
    }
}