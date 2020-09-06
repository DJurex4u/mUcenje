package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public abstract class Router {
    protected final NavController mNavController;

    public Router(Fragment fragment){
        mNavController = NavHostFragment.findNavController(fragment);
    }
}
