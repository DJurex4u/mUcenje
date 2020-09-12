package com.example.muenje.data.network.pojo;

import com.google.firebase.database.PropertyName;

public class QuizTitleResponse {
    @PropertyName("id")
    public final Integer mId;
    @PropertyName("title")
    public final String mTitle;

    public QuizTitleResponse(){
        mId = null;
        mTitle = null;
    }

    public QuizTitleResponse(Integer id,String title){
        mId = id;
        mTitle = title;
    }
}
