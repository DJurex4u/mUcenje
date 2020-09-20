package com.example.muenje.data.entities;

import java.util.List;

public class QuestionSet {
    final String correctAnswers;
    final List<String> possibleAnswers;
    final String question;

    public QuestionSet(String correctAnswers, List<String> possibleAnswers, String question) {
        this.correctAnswers = correctAnswers;
        this.possibleAnswers = possibleAnswers;
        this.question = question;
    }
}
