package com.example.muenje.data.entities;

import com.google.firebase.database.PropertyName;

public class LectionTitle {
    @PropertyName("id")
    final int mId;
    @PropertyName("title")
    final String mTitle;
    public LectionTitle(int id, String header){
        mId = id;
        mTitle = header;
    }

    public int getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }
}
