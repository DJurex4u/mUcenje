package com.example.muenje.ui;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class RxViewModel extends ViewModel {
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected CompositeDisposable getCompositeDisposable(){
        return mCompositeDisposable;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.clear();
        super.onCleared();
    }
}
