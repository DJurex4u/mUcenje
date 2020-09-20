package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.QuestionSet;
import com.example.muenje.data.network.pojo.QuestionSetResponse;

public class QuestionSetResponseToQuestionSetMapper extends SimpleListMapper<QuestionSetResponse, QuestionSet> {
    @Override
    public QuestionSet map(QuestionSetResponse objectToMap) {
        return new QuestionSet(objectToMap.correctAnswer, objectToMap.possibleAnswers, objectToMap.question);
    }
}
