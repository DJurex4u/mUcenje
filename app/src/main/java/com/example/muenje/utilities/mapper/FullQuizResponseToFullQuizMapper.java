package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.FullQuiz;
import com.example.muenje.data.entities.QuestionSet;
import com.example.muenje.data.network.pojo.FullQuizResponse;
import com.example.muenje.data.network.pojo.QuestionSetResponse;

public class FullQuizResponseToFullQuizMapper implements IMapper<FullQuizResponse, FullQuiz> {

    SimpleListMapper<QuestionSetResponse, QuestionSet> mQuestionSetResponseToQuestionSetMapper;

    public FullQuizResponseToFullQuizMapper(SimpleListMapper<QuestionSetResponse, QuestionSet> questionSetResponseToQuestionSetMapper) {
        mQuestionSetResponseToQuestionSetMapper = questionSetResponseToQuestionSetMapper;
    }

    @Override
    public FullQuiz map(FullQuizResponse objectToMap) {
        return new FullQuiz(
                objectToMap.id,
                 mQuestionSetResponseToQuestionSetMapper.mapList(objectToMap.questionSetResponse),
                objectToMap.title
        );
    }
}
