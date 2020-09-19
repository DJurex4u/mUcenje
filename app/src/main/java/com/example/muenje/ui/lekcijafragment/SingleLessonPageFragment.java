package com.example.muenje.ui.lekcijafragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.muenje.R;
import com.example.muenje.ui.lessonsfragmentcontainer.LessonsFragmentContainer;
import com.example.muenje.ui.lessonsfragmentcontainer.LessonsFragmentContainerViewModel;
import com.example.muenje.ui.profilfragment.ProfileViewModel;

public class SingleLessonPageFragment extends Fragment {

    private Integer mPosition;
    private SingleLessonPageViewModel mSingleLessonPageViewModel;
    private LessonsFragmentContainerViewModel mLessonsFragmentContainerViewModel;


    public static SingleLessonPageFragment newInstance(Bundle args) {
        SingleLessonPageFragment fragment = new SingleLessonPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = this.getArguments().getInt("page");
        mSingleLessonPageViewModel = new ViewModelProvider(requireActivity()).get(SingleLessonPageViewModel.class);
        mLessonsFragmentContainerViewModel = new ViewModelProvider(requireActivity()).get(LessonsFragmentContainerViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lekcija, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        connectViewModel();
    }

    void connectViewModel() {
        mLessonsFragmentContainerViewModel.getFullLesson()
                .observe(getViewLifecycleOwner(),
                        (lessons) -> mSingleLessonPageViewModel.mLessonBody
                                .setValue(lessons.getSingleBodie(mPosition)));
    }
}