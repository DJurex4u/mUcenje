package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.core.Router;
import com.example.muenje.ui.pickerFragment.PickerFragmentDirections;

public class PickerRouter extends Router {

    public PickerRouter(Fragment fragment) {
        super(fragment);
    }

    void navigateToLessonContainer(Integer lesionId){
        NavDirections action = PickerFragmentDirections.actionLekcijeFragmentToLekcijaFragmentContainer(lesionId);
        mNavController.navigate(action);
    }

    void navigateToQuizContainer(Integer quizId){
        NavDirections action = PickerFragmentDirections.actionLekcijeFragmentToIzazoviFragmentContainer2(quizId);
        mNavController.navigate(action);
    }
}
