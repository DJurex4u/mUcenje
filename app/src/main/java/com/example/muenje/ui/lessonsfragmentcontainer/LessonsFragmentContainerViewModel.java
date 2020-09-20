package com.example.muenje.ui.lessonsfragmentcontainer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.muenje.core.RxViewModel;
import com.example.muenje.data.entities.FullLesson;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.LessonsFragmentContainerInteractor;
import com.jakewharton.rxrelay3.PublishRelay;

import io.reactivex.rxjava3.core.Observable;

public class LessonsFragmentContainerViewModel extends RxViewModel {

   public enum GoTo{
      GO_BACK
   }

   LessonsFragmentContainerInteractor mInteractor;
   Integer mLessonId;
   private PublishRelay<LessonsFragmentContainerViewModel.GoTo> mNavigateTo = PublishRelay.create();
   MutableLiveData<FullLesson> mFullLesson = new MutableLiveData<>();
   User mUser;


   void setUpViewModel(LessonsFragmentContainerInteractor lessonInteractor, Integer lessonId,User user){
      mInteractor = lessonInteractor;
      mLessonId = lessonId;
      mUser = user;
   }

   void initViewModel(){
      mInteractor.getFullLesson(mLessonId);
      getCompositeDisposable().add(mInteractor.getFullLesson(mLessonId).subscribe(fullLesson -> mFullLesson.setValue(fullLesson)));
   }

   public LiveData<FullLesson> getFullLesson(){
      return mFullLesson;
   }

   public Observable<GoTo> getNavigationObservable(){
      return mNavigateTo;
   }

   public void GoBack(){
      mInteractor.setLessonReed(mUser.mDisplayName,mLessonId.toString());
      mNavigateTo.accept(GoTo.GO_BACK);
   }
}
