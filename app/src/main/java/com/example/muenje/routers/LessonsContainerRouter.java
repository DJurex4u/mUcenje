package com.example.muenje.routers;

import androidx.fragment.app.Fragment;

import com.example.muenje.core.Router;

public class LessonsContainerRouter extends Router {

    public LessonsContainerRouter(Fragment fragment) {
        super(fragment);
    }

    public void goBack(){
        mNavController.popBackStack();
    }


}
