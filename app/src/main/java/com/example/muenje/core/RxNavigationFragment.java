package com.example.muenje.core;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import io.reactivex.rxjava3.disposables.Disposable;

public class RxNavigation extends Fragment {

    private ArrayList<Disposable> mCompositeDisposable = new ArrayList<>();

    @Override
    public void onDestroy() {
        for(Disposable disposable: mCompositeDisposable) {
            disposable.dispose();
        }
        mCompositeDisposable.clear();
        super.onDestroy();
    }

    protected void addDisposableToCompositeDisposable(Disposable disposable){
        mCompositeDisposable.add(disposable);
    }
}
