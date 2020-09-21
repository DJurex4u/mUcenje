package com.example.muenje.ui.quizzesContainerFragment.quizFragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {
    public MutableLiveData<String> question = new MutableLiveData<>();
    public MutableLiveData<String> possibleAnswer1 = new MutableLiveData<>();
    public MutableLiveData<String> possibleAnswer2 = new MutableLiveData<>();
    public MutableLiveData<String> possibleAnswer3 = new MutableLiveData<>();
}
