package com.example.muenje.ui.pickerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.muenje.BaseApplication;
import com.example.muenje.R;
import com.example.muenje.adapters.TitleAdapter;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.PickerInteractor;
import com.example.muenje.databinding.FragmentPickerBinding;
import com.example.muenje.routers.PickerRouter;

public class PickerFragment extends Fragment implements TitleClickedCallback {

    FragmentPickerBinding mBinding;
    PickerViewModel mViewModel;
    TitleAdapter mAdapter;
    PickerRouter mRouter;

    WhatPicker mWhatPicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new TitleAdapter(this);
        PickerFragmentArgs args = PickerFragmentArgs.fromBundle(getArguments());
        mWhatPicker = args.getWhatPicker();
        User user = args.getUser();
        BaseApplication application = ((BaseApplication) requireActivity().getApplication());
        mViewModel = new ViewModelProvider(requireActivity()).get(PickerViewModel.class);
        mRouter = new PickerRouter(this);
        PickerInteractor interactor = new PickerInteractor(application.getRxFirebaseRealtimeDatabaseRepositoryHelper());
        mViewModel.setUpViewModel(interactor,mWhatPicker,user);
        mViewModel.initViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPickerBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpHeaderText();
        setUpRecyclerView();
        connectViewModel();
    }

    @Override
    public void titleClicked(Integer id) {
        switch (mWhatPicker){
            case LESSON_PICKER:
                mRouter.navigateToLessonContainer(id,mViewModel.getUser());
                break;
            case QUIZ_PICKER:
                mRouter.navigateToQuizContainer(id,mViewModel.getUser());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mWhatPicker);
        }
    }

    void connectViewModel(){
        mViewModel.getTitleList().observe(getViewLifecycleOwner(),(titleList -> mAdapter.setData(titleList)));
    }

    void setUpHeaderText(){
        switch (mWhatPicker){
            case LESSON_PICKER :
                mBinding.pickerHeaderTextView.setText(getContext().getText(R.string.lesson_picker_header_text));
                break;
            case QUIZ_PICKER:
                mBinding.pickerHeaderTextView.setText(getContext().getText(R.string.quiz_picker_header_text));
                break;
        }
    }

    void setUpRecyclerView(){
        mBinding.lessonsTitleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.lessonsTitleRecyclerView.setAdapter(mAdapter);
    }
}