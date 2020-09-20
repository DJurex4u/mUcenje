package com.example.muenje.routers;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.example.muenje.core.Router;
import com.example.muenje.data.entities.User;
import com.example.muenje.ui.pickerFragment.PickerFragmentDirections;

public class PickerRouter extends Router {

    public PickerRouter(Fragment fragment) {
        super(fragment);
    }

    public void navigateToLessonContainer(Integer lessonId, User user){
        NavDirections action = PickerFragmentDirections.actionLekcijeFragmentToLekcijaFragmentContainer(lessonId,user);
        mNavController.navigate(action);
    }

    public void navigateToQuizContainer(Integer quizId,User user){
        NavDirections action = PickerFragmentDirections.actionLekcijeFragmentToIzazoviFragmentContainer2(quizId,user);
        mNavController.navigate(action);
    }
}
