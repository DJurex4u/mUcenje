package com.example.muenje.data.entities;


import java.util.List;

public class FullQuiz {
    public final Integer id;
    public final List<QuestionSet> questionSet;
    public final String title;

    public FullQuiz(Integer id, List<QuestionSet> questionSet, String title) {
        this.id = id;
        this.questionSet = questionSet;
        this.title = title;
    }
}
