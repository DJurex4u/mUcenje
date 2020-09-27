package com.example.muenje.core;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

public class TestObservable{

    public static MaybeObserver<?> testMaybeObservable = new MaybeObserver<Object>() {
        @Override
        public void onSubscribe(Disposable d) {
        }

        @Override
        public void onSuccess(Object o) {
            Integer i = 4;
            i--;
        }

        @Override
        public void onError(Throwable e) {
            Integer i = 4;
            i--;
        }

        @Override
        public void onComplete() {
            Integer i = 4;
            i--;
        }
    };
}
