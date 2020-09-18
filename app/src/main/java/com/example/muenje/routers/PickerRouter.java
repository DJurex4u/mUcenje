package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.core.Router;
import com.example.muenje.ui.pickerFragment.PickerFragmentDirections;

public class PickerRouter extends Router {

    public PickerRouter(Fragment fragment) {
        super(fragment);
    }

    public void navigateToLessonContainer(Integer lessonId){
        NavDirections action = PickerFragmentDirections.actionLekcijeFragmentToLekcijaFragmentContainer(lessonId);
        mNavController.navigate(action);
    }

    public void navigateToQuizContainer(Integer quizId){
        NavDirections action = PickerFragmentDirections.actionLekcijeFragmentToIzazoviFragmentContainer2(quizId);
        mNavController.navigate(action);
    }
}
