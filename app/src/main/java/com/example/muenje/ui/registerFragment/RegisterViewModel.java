package com.example.muenje.ui.registerFragment;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.RegisterInteractor;
import com.jakewharton.rxrelay3.PublishRelay;

import io.reactivex.rxjava3.core.Observable;

public class RegisterViewModel extends RxViewModel {

    enum RegisterStatus {
        NOT_ALL_FILLED,
        EMAIL_ALREADY_IN_USE,
        PASSWORD_TOO_SHORT,
        PASSWORDS_DO_NOT_MATCH,
        REGISTERING,
        INVALID_EMAIL,
        REGISTERED,
        ERROR_REGISTRATION
    }

    public enum GoTo {
        GO_TO_LOGIN_PAGE
    }

    public MutableLiveData<String> mUsername = new MutableLiveData<>("");
    public MutableLiveData<String> mPassword = new MutableLiveData<>("");
    public MutableLiveData<String> mRepeatPassword = new MutableLiveData<>("");
    private PublishRelay<GoTo> mNavigateTo = PublishRelay.create();
    private RegisterInteractor mRegisterInteractor;
    private MutableLiveData<RegisterStatus> mRegisterStatus = new MutableLiveData<>(RegisterStatus.REGISTERING);
    private User mUser;


    public void setUpViewModel(RegisterInteractor registerInteractor) {
        mRegisterInteractor = registerInteractor;
    }

    public LiveData<RegisterStatus> getRegisterStatus(){
        return mRegisterStatus;
    }

    public void goToLoginFragment() {
        mNavigateTo.accept(GoTo.GO_TO_LOGIN_PAGE);
    }

    public Observable<GoTo> getNavigationObservable() {
        return mNavigateTo;
    }

    public void tryToRegisterUser() {
        if (!mUsername.getValue().isEmpty() && !mPassword.getValue().isEmpty() && !mRepeatPassword.getValue().isEmpty()) {
            if (mPassword.getValue().equals(mRepeatPassword.getValue())) {
                if (mPassword.getValue().length()>=6) {
                    getCompositeDisposable().add(mRegisterInteractor.createNewUser(mUsername.getValue(), mPassword.getValue()).subscribe(
                            (user -> {
                                mUser = user;
                                mRegisterStatus.setValue(RegisterStatus.REGISTERED);
                            }),
                            (error) -> {
                                switch (error.getMessage()){
                                    case FirebaseErrors.emailAlreadyInUse:
                                        mRegisterStatus.setValue(RegisterStatus.EMAIL_ALREADY_IN_USE);
                                        break;
                                    case FirebaseErrors.invalidEmail:
                                        mRegisterStatus.setValue(RegisterStatus.INVALID_EMAIL);
                                        break;
                                    default:
                                        String i = error.getMessage();
                                        mRegisterStatus.setValue(RegisterStatus.ERROR_REGISTRATION);
                                }
//                                String englishErrorMessage = error.getCause().getMessage();
//                                mRegisterStatus.setValue(RegisterStatus.ERROR_REGISTRATION);
                            })
                    );
                }else{
                    mRegisterStatus.setValue(RegisterStatus.PASSWORD_TOO_SHORT);
                }
            } else {
                mRegisterStatus.setValue(RegisterStatus.PASSWORDS_DO_NOT_MATCH);
            }
        } else {
            mRegisterStatus.setValue(RegisterStatus.NOT_ALL_FILLED);

        }
    }

    public User getUser() throws NullPointerException{
        if(mUser == null){
            throw new NullPointerException("RegisterViewModel: User is null");
        }
        return mUser;
    }

    private static class FirebaseErrors{
        private static final String emailAlreadyInUse = "The email address is already in use by another account.";
        private static final String invalidEmail = "The email address is badly formatted.";
    }
}
