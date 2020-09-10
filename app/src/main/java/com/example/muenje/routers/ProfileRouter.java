package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.core.Router;
import com.example.muenje.ui.profilfragment.ProfileFragmentDirections;

public class ProfileRouter extends Router {

    public ProfileRouter(Fragment fragment) {
        super(fragment);
    }

    public void navigateToAchievements(){
        NavDirections action = ProfileFragmentDirections.actionProfilFragmentToPostignucaFragment();
        mNavController.navigate(action);
    }

    public void navigateToMissions(){
        NavDirections action = ProfileFragmentDirections.actionProfilFragmentToMisijeFragment();
        mNavController.navigate(action);
    }
}
