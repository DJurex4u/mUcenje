package com.example.muenje.core;

import androidx.fragment.app.Fragment;

import com.example.muenje.core.Router;

public abstract class BackRouter extends Router {
    public BackRouter(Fragment fragment) {
        super(fragment);
    }

    public void goBack(){
        mNavController.popBackStack();
    }
}
