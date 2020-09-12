package com.example.muenje.ui.pickerFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.Title;
import com.example.muenje.data.interactor.PickerInteractor;

import java.util.List;

public class PickerViewModel extends RxViewModel {

    private PickerInteractor mInteractor;

    private MutableLiveData<List<Title>> mTitleList = new MutableLiveData<>();

    private WhatPicker mWhatPicker;



    void setUpViewModel(PickerInteractor pickerInteractor, WhatPicker whatPicker){
        mInteractor = pickerInteractor;
        mWhatPicker = whatPicker;
    }

    void initViewModel(){
        switch (mWhatPicker){
            case LESSON_PICKER:
                getCompositeDisposable().add(mInteractor.getLessonsTitles().subscribe((titleList) -> mTitleList.setValue(titleList)));
                break;
            case QUIZ_PICKER:
                getCompositeDisposable().add(mInteractor.getQuizzesTitles().subscribe((titleList) -> mTitleList.setValue(titleList)));
                break;
        }
    }

    LiveData<List<Title>> getTitleList(){
        return mTitleList;
    }
}
