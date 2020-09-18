package com.example.muenje.ui.lekcijafragmentcontainer;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.interactor.LessonFragmentContainerInteractor;

public class LekcijaFragmentContainerViewModel extends RxViewModel {

   LessonFragmentContainerInteractor mInteractor;
   Integer mLessonId;


   void setUpViewModel(LessonFragmentContainerInteractor interactor,Integer lessonId){
      mInteractor = interactor;
      mLessonId = lessonId;
   }

   void initViewModel(){
      mInteractor.getFullLesson(mLessonId);
   }
}
