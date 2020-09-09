package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

public class MissionsRouter extends Router {

    public MissionsRouter(Fragment fragment) {
        super(fragment);
    }

    public void navigateToLections(){
        NavDirections action;
                mNavController.navigate(action);
    }
}
