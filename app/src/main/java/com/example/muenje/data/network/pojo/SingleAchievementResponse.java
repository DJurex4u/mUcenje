package com.example.muenje.data.network.pojo;

import com.google.firebase.database.PropertyName;

public class SingleAchievementResponse {
    @PropertyName("displayName")
    final public String displayName;
    @PropertyName("isAchieved")
    final public Boolean isAchieved;

    public SingleAchievementResponse() {
        displayName = null;
        isAchieved = null;
    }

    public SingleAchievementResponse(String displayName, Boolean isAchieved) {
        this.displayName = displayName;
        this.isAchieved = isAchieved;
    }
}
