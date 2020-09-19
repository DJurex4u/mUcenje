package com.example.muenje.ui.lekcijafragmentcontainer;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.interactor.LessonFragmentContainerInteractor;

public class LekcijaFragmentContainerViewModel extends RxViewModel {

   LessonFragmentContainerInteractor mInteractor;
   Integer mLessonId;


   void setUpViewModel(LessonFragmentContainerInteractor lessonInteractor, Integer lessonId){
      mInteractor = lessonInteractor;
      mLessonId = lessonId;
   }

   void initViewModel(){
      mInteractor.getFullLesson(mLessonId);
//            getCompositeDisposable().add(mInteractor.getFullLesson(mLessonId).subscribe((fullLesson -> mFullLesson.setValue(fullLesson)))
   }
}
