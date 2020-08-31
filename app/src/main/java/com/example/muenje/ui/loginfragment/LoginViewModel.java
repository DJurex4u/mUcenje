package com.example.muenje.ui.loginfragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    MutableLiveData<String> mUsername = new MutableLiveData<>();
    MutableLiveData<String> mPassword = new MutableLiveData<>();
}
