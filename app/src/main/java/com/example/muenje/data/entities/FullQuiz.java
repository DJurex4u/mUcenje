package com.example.muenje.data.entities;


import java.util.List;

public class FullQuiz {
    final Integer id;
    final List<QuestionSet> questionSet;
    final String title;

    public FullQuiz(Integer id, List<QuestionSet> questionSet, String title) {
        this.id = id;
        this.questionSet = questionSet;
        this.title = title;
    }
}
