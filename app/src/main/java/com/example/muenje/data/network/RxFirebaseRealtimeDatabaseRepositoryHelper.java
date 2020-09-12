package com.example.muenje.data.network;

import com.example.muenje.data.entities.LectionTitle;
import com.example.muenje.utilities.mapper.LectionTitleResponseToLectionTitleMapper;
import com.example.muenje.utilities.schedulers.AppSchedulerProvider;

import java.util.List;

import io.reactivex.Maybe;

public class RxFirebaseRealtimeDatabaseRepositoryHelper {

    final RxFirebaseRealtimeDatabaseRepository mRxFirebaseRealtimeDatabaseRepository;
    final AppSchedulerProvider mAppSchedulerProvider;
    final LectionTitleResponseToLectionTitleMapper mLectionTitleResponseToLectionTitleMapper;

    public RxFirebaseRealtimeDatabaseRepositoryHelper(RxFirebaseRealtimeDatabaseRepository rxFirebaseRealtimeDatabaseRepository,AppSchedulerProvider appSchedulerProvider,LectionTitleResponseToLectionTitleMapper lectionTitleResponseToLectionTitleMapper){
        mRxFirebaseRealtimeDatabaseRepository = rxFirebaseRealtimeDatabaseRepository;
        mAppSchedulerProvider = appSchedulerProvider;
        mLectionTitleResponseToLectionTitleMapper = lectionTitleResponseToLectionTitleMapper;
    }

    public Maybe<List<LectionTitle>> getLectionsTitles(){
        return mRxFirebaseRealtimeDatabaseRepository.getLectionTitles()
                .subscribeOn(mAppSchedulerProvider.io())
                .map((lectionTitleResponseList) ->  mLectionTitleResponseToLectionTitleMapper.mapList(lectionTitleResponseList))
                .observeOn(mAppSchedulerProvider.ui());
    }
}
