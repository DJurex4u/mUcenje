package com.example.muenje.utilities;

import java.util.List;

public class AnswerChecker {
    final List<String> mRightAnswers;


    public AnswerChecker(List<String> mRightAnswers) {
        this.mRightAnswers = mRightAnswers;
    }

    public boolean checkAnswer(String chosenAnswer,Integer position) {
        return chosenAnswer.equals(mRightAnswers.get(position));
    }
}
