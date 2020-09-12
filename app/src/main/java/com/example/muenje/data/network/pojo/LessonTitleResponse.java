package com.example.muenje.data.network.pojo;

import com.google.firebase.database.PropertyName;

public class LessonTitleResponse {
    @PropertyName("id")
    public final Integer mId;
    @PropertyName("title")
    public final String mTitle;

    public LessonTitleResponse(){
        mId = null;
        mTitle = null;
    }

    public LessonTitleResponse(Integer id, String title){
        mId = id;
        mTitle = title;
    }

}
