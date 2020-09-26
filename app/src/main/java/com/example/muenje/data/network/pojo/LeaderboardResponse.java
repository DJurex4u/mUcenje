package com.example.muenje.data.network.pojo;

import java.util.List;

public class LeaderboardResponse {

    public final List<SingleLeaderboardEntryResponse> userList;

    public LeaderboardResponse(List<SingleLeaderboardEntryResponse> userList) {
        this.userList = userList;
    }
}
