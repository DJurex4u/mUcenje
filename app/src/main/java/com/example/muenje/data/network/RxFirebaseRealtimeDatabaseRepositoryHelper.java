package com.example.muenje.data.network;

import com.example.muenje.data.entities.FullLesson;
import com.example.muenje.data.entities.FullQuiz;
import com.example.muenje.data.entities.SingleAchievement;
import com.example.muenje.data.entities.Title;
import com.example.muenje.data.entities.User;
import com.example.muenje.utilities.mapper.FullLessonResponseToFullLessonMapper;
import com.example.muenje.utilities.mapper.FullQuizResponseToFullQuizMapper;
import com.example.muenje.utilities.mapper.LessonTitleResponseToTitleMapper;
import com.example.muenje.utilities.mapper.QuizTitleResponseToTitleMapper;
import com.example.muenje.utilities.mapper.SingleAchievementResponseToSingleAchievementMapper;
import com.example.muenje.utilities.schedulers.AppSchedulerProvider;

import java.util.List;

import io.reactivex.Maybe;

public class RxFirebaseRealtimeDatabaseRepositoryHelper {

    final RxFirebaseRealtimeDatabaseRepository mRxFirebaseRealtimeDatabaseRepository;
    final AppSchedulerProvider mAppSchedulerProvider;
    final LessonTitleResponseToTitleMapper mLessonTitleResponseToTitleMapper;
    final FullLessonResponseToFullLessonMapper mFullLessonResponseToFullLessonMapper;
    final QuizTitleResponseToTitleMapper mQuizTitleResponseToTitleMapper;
    final SingleAchievementResponseToSingleAchievementMapper mSingleAchievementResponseToSingleAchievementMapper;
    final FullQuizResponseToFullQuizMapper mFullQuizResponseToFullQuizMapper;

    public RxFirebaseRealtimeDatabaseRepositoryHelper(RxFirebaseRealtimeDatabaseRepository rxFirebaseRealtimeDatabaseRepository, AppSchedulerProvider appSchedulerProvider, LessonTitleResponseToTitleMapper lessonTitleResponseToTitleMapper, FullLessonResponseToFullLessonMapper fullLessonResponseToFullLessonMapper, QuizTitleResponseToTitleMapper quizTitleResponseToTitleMapper, SingleAchievementResponseToSingleAchievementMapper singleAchievementResponseToSingleAchievementMapper,FullQuizResponseToFullQuizMapper fullQuizResponseToFullQuizMapper) {
        mRxFirebaseRealtimeDatabaseRepository = rxFirebaseRealtimeDatabaseRepository;
        mAppSchedulerProvider = appSchedulerProvider;
        mLessonTitleResponseToTitleMapper = lessonTitleResponseToTitleMapper;
        mFullLessonResponseToFullLessonMapper = fullLessonResponseToFullLessonMapper;
        mQuizTitleResponseToTitleMapper = quizTitleResponseToTitleMapper;
        mSingleAchievementResponseToSingleAchievementMapper = singleAchievementResponseToSingleAchievementMapper;
        mFullQuizResponseToFullQuizMapper = fullQuizResponseToFullQuizMapper;
    }

    public Maybe<List<Title>> getLessonsTitles() {
        return mRxFirebaseRealtimeDatabaseRepository.getLessonsTitles()
                .subscribeOn(mAppSchedulerProvider.io())
                .map((lessonTitleResponseList) -> mLessonTitleResponseToTitleMapper.mapList(lessonTitleResponseList))
                .observeOn(mAppSchedulerProvider.ui());
    }

    public Maybe<FullLesson> getFullLesson(Integer id) {
        return mRxFirebaseRealtimeDatabaseRepository.getFullLesson(id)
                .subscribeOn(mAppSchedulerProvider.io())
                .map((fullLessonResponse) -> mFullLessonResponseToFullLessonMapper.map(fullLessonResponse))
                .observeOn(mAppSchedulerProvider.ui());
    }

    public Maybe<List<Title>> getQuizTitles() {
        return mRxFirebaseRealtimeDatabaseRepository.getQuizTitles()
                .subscribeOn(mAppSchedulerProvider.io())
                .map((quizTitleResponseList) -> mQuizTitleResponseToTitleMapper.mapList(quizTitleResponseList))
                .observeOn(mAppSchedulerProvider.ui());
    }

    public Maybe<FullQuiz> getFullQuiz(Integer quizId){
        return mRxFirebaseRealtimeDatabaseRepository.getFullQuiz(quizId)
                .subscribeOn(mAppSchedulerProvider.io())
                .map((fullQuizResponse) -> mFullQuizResponseToFullQuizMapper.map(fullQuizResponse))
                .observeOn(mAppSchedulerProvider.ui());
    }

    public Maybe<List<SingleAchievement>> getUserAchievements(User user) {
        return mRxFirebaseRealtimeDatabaseRepository.getUsersAchievements(user.mDisplayName)
                .subscribeOn(mAppSchedulerProvider.io())
                .map((responseList) -> mSingleAchievementResponseToSingleAchievementMapper.mapList(responseList))
                .observeOn(mAppSchedulerProvider.ui());
    }

    public void setLessonRed(String username, String lessonId){
        mRxFirebaseRealtimeDatabaseRepository.setLessonReed(username,lessonId);
    }

    public void setQuizSolved(String username,String quizId){
        mRxFirebaseRealtimeDatabaseRepository.setQuizSolved(username,quizId);
    }
}