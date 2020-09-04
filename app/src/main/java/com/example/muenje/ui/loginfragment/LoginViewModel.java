package com.example.muenje.ui.loginfragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
   public MutableLiveData<String> mUsername = new MutableLiveData<>();
   public MutableLiveData<String> mPassword = new MutableLiveData<>();

   public void setUpViewModel(){
      //TODO:
   }

   public void tryToLoginUser(){

   }
}
