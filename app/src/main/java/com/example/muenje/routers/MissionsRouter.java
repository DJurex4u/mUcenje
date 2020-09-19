package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.core.Router;
import com.example.muenje.ui.pickerFragment.WhatPicker;
import com.example.muenje.ui.misijefragment.MissionsFragmentDirections;

public class MissionsRouter extends Router {

    public MissionsRouter(Fragment fragment) {
        super(fragment);
    }

    public void navigateToLections(){
        NavDirections action = MissionsFragmentDirections.actionMisijeFragmentToLekcijeFragment(WhatPicker.LESSON_PICKER);
        mNavController.navigate(action);
    }

    public void navigateToChallenges(){
        NavDirections action = MissionsFragmentDirections.actionMisijeFragmentToLekcijeFragment(WhatPicker.QUIZ_PICKER);
        mNavController.navigate(action);
    }
}
