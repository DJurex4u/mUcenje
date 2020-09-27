package com.example.muenje.data.network.pojo;

public class SingleLeaderboardEntryResponse {
    public final String username;
    public final Integer points;

    public SingleLeaderboardEntryResponse(String username, Integer points) {
        this.username = username;
        this.points = points;
    }
}
