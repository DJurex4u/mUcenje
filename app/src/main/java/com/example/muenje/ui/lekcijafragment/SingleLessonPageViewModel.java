package com.example.muenje.ui.lekcijafragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SingleLessonPageViewModel extends ViewModel {
    public MutableLiveData<String> lessonBody = new MutableLiveData<>();
    public MutableLiveData<String> lessonTitle = new MutableLiveData<>();
}
