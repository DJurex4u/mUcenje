package com.example.muenje.data.network.pojo;

import java.util.ArrayList;
import java.util.List;

public class QuestionSetResponse {
    public final String correctAnswer;
    public final List<String> possibleAnswers;
    public final String question;

    public QuestionSetResponse() {
        correctAnswer = null;
        possibleAnswers = null;
        question = null;
    }

    public QuestionSetResponse(String correctAnswer, ArrayList<String> possibleAnswers, String question) {
        this.correctAnswer = correctAnswer;
        this.possibleAnswers = possibleAnswers;
        this.question = question;
    }
}
