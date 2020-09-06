package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.muenje.data.entities.User;
import com.example.muenje.ui.loginfragment.LoginFragmentDirections;


public class LoginRouter {

    private final NavController mNavController;

    public LoginRouter(Fragment fragment) {
        mNavController = NavHostFragment.findNavController(fragment);
    }

    public void goToProfilePage(User user){
        NavDirections action = LoginFragmentDirections.actionLoginFragmentToProfilFragment(user);
        mNavController.navigate(action);
    }
}
