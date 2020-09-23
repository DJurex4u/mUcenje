package com.example.muenje.ui.registerFragment;


import androidx.lifecycle.MutableLiveData;

import com.example.muenje.core.RxViewModel;

public class RegisterViewModel extends RxViewModel {

    public MutableLiveData<String> mUsername = new MutableLiveData<>("");
    public MutableLiveData<String> mPassword = new MutableLiveData<>("");
    public MutableLiveData<String> mRepeatPassword = new MutableLiveData<>("");

}
