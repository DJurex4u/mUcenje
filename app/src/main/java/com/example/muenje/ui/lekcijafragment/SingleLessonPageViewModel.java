package com.example.muenje.ui.lekcijafragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SingleLessonPageViewModel extends ViewModel {
    //samo insatncu pagea i subcribe na container i preko arrgs dati što treba i dat signlepage view model i onda bindat na viewmodel

    public MutableLiveData<String> mLessonBody = new MutableLiveData<>();
}
