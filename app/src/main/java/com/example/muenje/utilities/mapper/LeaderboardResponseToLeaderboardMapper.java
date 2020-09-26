package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.Leaderboard;
import com.example.muenje.data.network.pojo.LeaderboardResponse;

public class LeaderboardResponseToLeaderboardMapper implements IMapper<LeaderboardResponse, Leaderboard> {

    private final SingleLarboardEntryResponseToSingleLarboardEntryMapper mMapper;

    public LeaderboardResponseToLeaderboardMapper(SingleLarboardEntryResponseToSingleLarboardEntryMapper mapper) {
        this.mMapper = mapper;
    }

    @Override
    public Leaderboard map(LeaderboardResponse objectToMap) {
        return new Leaderboard(mMapper.mapList(objectToMap.userList));
    }
}
