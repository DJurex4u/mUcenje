package com.example.muenje.data.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaderboard {

    public final List<SingleLeaderboardEntry> userList;

    private List<SingleLeaderboardEntry> orderedUserList;

    public Leaderboard(List<SingleLeaderboardEntry> userList) {
        Collections.sort(userList, (o1, o2) -> o1.points.compareTo(o2.points));
        this.userList = userList;
    }

    public List<SingleLeaderboardEntry> getOrderedList() {
        if (orderedUserList == null) {
            List<SingleLeaderboardEntry> clonedList = new ArrayList<>(userList);
            Collections.sort(clonedList, (o1, o2) -> o1.points.compareTo(o2.points));
            orderedUserList = clonedList;
        }
        return orderedUserList;
    }
}
