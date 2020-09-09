package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.data.entities.User;
import com.example.muenje.ui.loginfragment.LoginFragmentDirections;


public class LoginRouter extends Router {

    public LoginRouter(Fragment fragment)  {
        super(fragment);
    }

    public void navigateToProfilePage(User user){
        NavDirections action = LoginFragmentDirections.actionLoginFragmentToProfilFragment(user);
        mNavController.navigate(action);
    }
}
