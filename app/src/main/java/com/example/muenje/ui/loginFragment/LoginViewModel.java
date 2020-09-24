package com.example.muenje.ui.loginFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.LoginInteractor;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;


public class LoginViewModel extends RxViewModel {
   
   enum LoginStatus{
      LOGGING_IN,
      LOGGED_IN,
      ERROR_LOGIN
   }

   public enum GoTo {
      GO_TO_REGISTER_PAGE
   }

   
   private LoginInteractor mLoginInteractor;
   private PublishRelay<LoginViewModel.GoTo> mNavigateTo = PublishRelay.create();
   public MutableLiveData<String> mUsername = new MutableLiveData<>("");
   public MutableLiveData<String> mPassword = new MutableLiveData<>("");
   private MutableLiveData<LoginStatus> mLoginStatus = new MutableLiveData<>(LoginStatus.LOGGING_IN);

   private User mUser;

   public void setUpViewModel(LoginInteractor loginInteractor){
      mLoginInteractor = loginInteractor;
   }

   public void tryToLoginUser(){
      if(!mUsername.getValue().isEmpty() && !mPassword.getValue().isEmpty()) {
         getCompositeDisposable().add(mLoginInteractor.authenticateUser(mUsername.getValue(), mPassword.getValue()).subscribe(
                 (user -> {
                    mUser = user;
                    mLoginStatus.setValue(LoginStatus.LOGGED_IN);
                 }),
                 (error -> mLoginStatus.setValue(LoginStatus.ERROR_LOGIN))
         ));
      }else {
         mLoginStatus.setValue(LoginStatus.ERROR_LOGIN);
      }
   }

   public LiveData<LoginStatus> getLoginStatus(){
      return mLoginStatus;
   }

   public User getUser(){
      if(mUser == null){
         throw new NullPointerException("LoginViewModel: User is null");
      }
      return mUser;
   }

   public void goToRegisterFragment (){
      mNavigateTo.accept(GoTo.GO_TO_REGISTER_PAGE);
   }

   public Observable<GoTo> getNavigationObservable(){
      return mNavigateTo;
   }

}
