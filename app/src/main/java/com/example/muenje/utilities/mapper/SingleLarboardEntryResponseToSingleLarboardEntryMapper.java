package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.SingleLeaderboardEntry;
import com.example.muenje.data.network.pojo.SingleLeaderboardEntryResponse;

public class SingleLarboardEntryResponseToSingleLarboardEntryMapper extends SimpleListMapper<SingleLeaderboardEntryResponse, SingleLeaderboardEntry> {
    @Override
    public SingleLeaderboardEntry map(SingleLeaderboardEntryResponse objectToMap) {
        return new SingleLeaderboardEntry(objectToMap.username,objectToMap.points);
    }
}
