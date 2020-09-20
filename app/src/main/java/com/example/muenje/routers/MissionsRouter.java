package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.core.Router;
import com.example.muenje.data.entities.User;
import com.example.muenje.ui.pickerFragment.WhatPicker;
import com.example.muenje.ui.missionsfragment.MissionsFragmentDirections;

public class MissionsRouter extends Router {

    public MissionsRouter(Fragment fragment) {
        super(fragment);
    }

    public void navigateToLections(User user){
        NavDirections action = MissionsFragmentDirections.actionMisijeFragmentToLekcijeFragment(WhatPicker.LESSON_PICKER,user);
        mNavController.navigate(action);
    }

    public void navigateToChallenges(User user){
        NavDirections action = MissionsFragmentDirections.actionMisijeFragmentToLekcijeFragment(WhatPicker.QUIZ_PICKER,user);
        mNavController.navigate(action);
    }
}
