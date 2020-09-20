package com.example.muenje.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuizSharedViewModel extends ViewModel {

    public MutableLiveData<Boolean> showNextButton = new MutableLiveData<>(true);

}
