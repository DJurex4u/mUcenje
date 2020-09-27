package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.core.Router;
import com.example.muenje.data.entities.User;
import com.example.muenje.ui.registerFragment.RegisterFragment;
import com.example.muenje.ui.registerFragment.RegisterFragmentDirections;

public class RegisterRouter extends Router {

    public RegisterRouter(Fragment fragment) {
        super(fragment);
    }

    public void navigateToProfilePage(User user){
        NavDirections action = RegisterFragmentDirections.actionRegisterFragmentToProfilFragment(user);
        mNavController.navigate(action);
    }

    public void navigateToLoginPage(){
        NavDirections action = RegisterFragmentDirections.actionGlobalLoginFragment();
        mNavController.navigate(action);
    }
}
