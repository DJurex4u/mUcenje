package com.example.muenje.ui.lessonsFragmentContainer.lessonFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.muenje.databinding.FragmentSingleLessonPageBinding;
import com.example.muenje.ui.lessonsFragmentContainer.LessonsFragmentContainerViewModel;

public class SingleLessonPageFragment extends Fragment {

    private Integer mPosition;
    private SingleLessonPageViewModel mSingleLessonPageViewModel;
    private LessonsFragmentContainerViewModel mLessonsFragmentContainerViewModel;
    private FragmentSingleLessonPageBinding mBinding;



    public static SingleLessonPageFragment newInstance(Bundle args) {
        SingleLessonPageFragment fragment = new SingleLessonPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = this.getArguments().getInt("page");
        mSingleLessonPageViewModel = new ViewModelProvider(this).get(SingleLessonPageViewModel.class);
        mLessonsFragmentContainerViewModel = new ViewModelProvider(requireActivity()).get(LessonsFragmentContainerViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentSingleLessonPageBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
        //return inflater.inflate(R.layout.fragment_single_lesson_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        connectViewModel();
        mBinding.setViewModel(mSingleLessonPageViewModel);
    }

    void connectViewModel() {
        mLessonsFragmentContainerViewModel.getFullLesson()
                .observe(getViewLifecycleOwner(),
                        (lessons) -> {
                            mSingleLessonPageViewModel.lessonBody
                                    .setValue(lessons.getSingleBody(mPosition));
                            mSingleLessonPageViewModel.lessonTitle
                                    .setValue(lessons.getTitle());
                        });

        mSingleLessonPageViewModel.lessonBody.observe(getViewLifecycleOwner(),(body) -> {
            mBinding.lessonBodyTextView.setText(body);}
            );
    }
}
