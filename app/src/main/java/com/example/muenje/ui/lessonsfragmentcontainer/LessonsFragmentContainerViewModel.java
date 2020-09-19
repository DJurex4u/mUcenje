package com.example.muenje.ui.lessonsfragmentcontainer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.FullLesson;
import com.example.muenje.data.interactor.LessonsFragmentContainerInteractor;

public class LessonsFragmentContainerViewModel extends RxViewModel {

   LessonsFragmentContainerInteractor mInteractor;
   Integer mLessonId;
   MutableLiveData<FullLesson> mFullLesson = new MutableLiveData<>();


   void setUpViewModel(LessonsFragmentContainerInteractor lessonInteractor, Integer lessonId){
      mInteractor = lessonInteractor;
      mLessonId = lessonId;
   }

   void initViewModel(){
      mInteractor.getFullLesson(mLessonId);
      getCompositeDisposable().add(mInteractor.getFullLesson(mLessonId).subscribe(fullLesson -> mFullLesson.setValue(fullLesson)));
   }

   public LiveData<FullLesson> getFullLesson(){
      return mFullLesson;
   }
}
