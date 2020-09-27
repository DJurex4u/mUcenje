package com.example.muenje.data.entities;

import androidx.annotation.NonNull;

public class SingleLeaderboardEntry {

    public final String username;
    public final Integer points;

    public SingleLeaderboardEntry(String username, Integer points) {
        this.username = username;
        this.points = points;
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new SingleLeaderboardEntry(username,points);
    }
}
