package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.SingleAchievement;
import com.example.muenje.data.network.pojo.SingleAchievementResponse;

public class SingleAchievementResponseToSingleAchievementMapper extends SimpleListMapper<SingleAchievementResponse, SingleAchievement> {
    @Override
    public SingleAchievement map(SingleAchievementResponse objectToMap) {
        return new SingleAchievement(objectToMap.displayName,objectToMap.isAchieved);
    }
}
