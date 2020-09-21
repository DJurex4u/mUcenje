package com.example.muenje.data.network.pojo;

import com.google.firebase.database.PropertyName;

import java.util.List;

public class FullQuizResponse {
    public final Integer id;
    @PropertyName("questionsSet")
    public final List<QuestionSetResponse> questionSetResponse;
    public final String title;


    public FullQuizResponse() {
        id = null;
        questionSetResponse = null;
        title = null;
    }

    public FullQuizResponse(Integer id, List<QuestionSetResponse> questionSetResponse, String title) {
        this.id = id;
        this.questionSetResponse = questionSetResponse;
        this.title = title;
    }
}
