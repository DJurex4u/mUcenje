package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.core.Router;
import com.example.muenje.data.entities.User;
import com.example.muenje.ui.profilfragment.ProfileFragmentDirections;

public class ProfileRouter extends Router {

    public ProfileRouter(Fragment fragment) {
        super(fragment);
    }

    public void navigateToAchievements(User user){
        NavDirections action = ProfileFragmentDirections.actionProfilFragmentToAchievementsFragment(user);
        mNavController.navigate(action);
    }

    public void navigateToMissions(){
        NavDirections action = ProfileFragmentDirections.actionProfilFragmentToMisijeFragment();
        mNavController.navigate(action);
    }
}
