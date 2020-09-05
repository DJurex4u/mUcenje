package com.example.muenje.ui.loginfragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.BaseApplication;
import com.data.interactor.LoginInteractor;

public class LoginViewModel extends ViewModel {
   
   enum LoginStatus{
      LOGGING_IN,
      LOGGED_IN,
      ERROR_LOGIN
   }
   
   private LoginInteractor mLoginInteractor;
   public MutableLiveData<String> mUsername = new MutableLiveData<>();
   public MutableLiveData<String> mPassword = new MutableLiveData<>();
   private MutableLiveData<LoginStatus> mLoginStatus = new MutableLiveData<>(LoginStatus.LOGGING_IN);

   public void setUpViewModel(LoginInteractor loginInteractor){
      mLoginInteractor = loginInteractor;
   }

   public void tryToLoginUser(){
      //zove interactor
      //po to maybeju što vraća interactor postavlja LiveData na "logged in" "eroor" "logingIn"

   }

   public LiveData<LoginStatus> getLoginStatus(){
      return mLoginStatus;
   }

}
