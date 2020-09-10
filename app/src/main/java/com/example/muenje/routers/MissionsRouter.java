package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.core.Router;
import com.example.muenje.ui.misijefragment.MissionsFragmentDirections;

public class MissionsRouter extends Router {

    public MissionsRouter(Fragment fragment) {
        super(fragment);
    }

    public void navigateToLections(){
        NavDirections action = MissionsFragmentDirections.actionMisijeFragmentToLekcijeFragment();
        mNavController.navigate(action);
    }

    public void navigateToChallenges(){
        NavDirections action = MissionsFragmentDirections.actionMisijeFragmentToIzazoviFragment();
        mNavController.navigate(action);
    }
}
