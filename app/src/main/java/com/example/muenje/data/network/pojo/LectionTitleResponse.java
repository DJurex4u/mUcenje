package com.example.muenje.data.network.pojo;

import com.example.muenje.data.entities.LectionTitle;
import com.google.firebase.database.PropertyName;

public class LectionTitleResponse {
    @PropertyName("id")
    public final Integer mId;
    @PropertyName("title")
    public final String mTitle;

    public LectionTitleResponse(){
        mId = null;
        mTitle = null;
    }

    public LectionTitleResponse(Integer id,String title){
        mId = id;
        mTitle = title;
    }

}
