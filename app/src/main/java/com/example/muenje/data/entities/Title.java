package com.example.muenje.data.entities;

public class Title {
    final int mId;
    final String mTitle;

    public Title(int id, String header) {
        mId = id;
        mTitle = header;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }
}
