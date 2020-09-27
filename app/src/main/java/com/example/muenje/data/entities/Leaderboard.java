package com.example.muenje.data.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaderboard {

    public final List<SingleLeaderboardEntry> userList;

    private List<SingleLeaderboardEntry> orderedUserListAscending;
    private List<SingleLeaderboardEntry> orderedUserListDescending;


    public Leaderboard(List<SingleLeaderboardEntry> userList) {
        Collections.sort(userList, (o1, o2) -> o1.points.compareTo(o2.points));
        this.userList = userList;
    }

    public List<SingleLeaderboardEntry> getOrderedListAscending() {
        if (orderedUserListAscending == null) {
            List<SingleLeaderboardEntry> clonedList = new ArrayList<>(userList);
            Collections.sort(clonedList, (o1, o2) -> o1.points.compareTo(o2.points));
            orderedUserListAscending = clonedList;
        }
        return orderedUserListAscending;
    }

    public List<SingleLeaderboardEntry> getOrderedListDescending() {
        if (orderedUserListDescending == null) {
            List<SingleLeaderboardEntry> clonedList = new ArrayList<>(userList);
            Collections.sort(clonedList, (o2, o1) -> o1.points.compareTo(o2.points));
            orderedUserListDescending = clonedList;
        }
        return orderedUserListDescending;
    }

}
