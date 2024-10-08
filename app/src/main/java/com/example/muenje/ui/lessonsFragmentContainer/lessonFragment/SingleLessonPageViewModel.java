package com.example.muenje.ui.lessonsFragmentContainer.lessonFragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SingleLessonPageViewModel extends ViewModel {
    public MutableLiveData<String> lessonBody = new MutableLiveData<>();
    public MutableLiveData<String> lessonTitle = new MutableLiveData<>();
    public MutableLiveData<Integer> currentLessonPage = new MutableLiveData<>();
    public MutableLiveData<Integer> totalLessonPages = new MutableLiveData<>();
}
