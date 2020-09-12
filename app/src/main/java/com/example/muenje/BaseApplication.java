package com.example.muenje;

import android.app.Application;

import com.example.muenje.data.network.RxFirebaseAuthHelper;
import com.example.muenje.data.network.RxFirebaseAuthRepository;
import com.example.muenje.data.network.RxFirebaseRealtimeDatabaseRepository;
import com.example.muenje.data.network.RxFirebaseRealtimeDatabaseRepositoryHelper;
import com.example.muenje.utilities.mapper.AuthResultToUserMapper;
import com.example.muenje.utilities.mapper.FullLessonResponseToFullLessonMapper;
import com.example.muenje.utilities.mapper.LessonTitleResponseToTitleMapper;
import com.example.muenje.utilities.mapper.QuizTitleResponseToTitleMapper;
import com.example.muenje.utilities.mapper.SingleAchievementResponseToSingleAchievementMapper;
import com.example.muenje.utilities.schedulers.AppSchedulerProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseApplication extends Application {
    //will create only one instance of:
    private RxFirebaseAuthHelper mRxFirebaseHelper;
    private RxFirebaseRealtimeDatabaseRepositoryHelper mRxFirebaseRealtimeDatabaseRepositoryHelper;

    @Override
    public void onCreate() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        AppSchedulerProvider appSchedulerProvider = new AppSchedulerProvider();
        RxFirebaseAuthRepository mRxFirebaseRepository = new RxFirebaseAuthRepository(mAuth);
        mRxFirebaseHelper = new RxFirebaseAuthHelper(mRxFirebaseRepository, new AuthResultToUserMapper(), appSchedulerProvider);
        RxFirebaseRealtimeDatabaseRepository rxFirebaseRealtimeDatabaseRepository = new RxFirebaseRealtimeDatabaseRepository(firebaseDatabase);
        mRxFirebaseRealtimeDatabaseRepositoryHelper = new RxFirebaseRealtimeDatabaseRepositoryHelper(rxFirebaseRealtimeDatabaseRepository, appSchedulerProvider, new LessonTitleResponseToTitleMapper(), new FullLessonResponseToFullLessonMapper(), new QuizTitleResponseToTitleMapper(),new SingleAchievementResponseToSingleAchievementMapper());
        super.onCreate();
    }

    public RxFirebaseAuthHelper getRxFirebaseHelperInstance() {
        return mRxFirebaseHelper;
    }

    public RxFirebaseRealtimeDatabaseRepositoryHelper getRxFirebaseRealtimeDatabaseRepositoryHelper() {
        return mRxFirebaseRealtimeDatabaseRepositoryHelper;
    }
}
