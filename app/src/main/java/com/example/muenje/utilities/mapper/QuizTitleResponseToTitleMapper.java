package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.Title;
import com.example.muenje.data.network.pojo.QuizTitleResponse;

public class QuizTitleResponseToTitleMapper extends SimpleListMapper<QuizTitleResponse, Title> {
    @Override
    public Title map(QuizTitleResponse objectToMap) {
        return new Title(objectToMap.mId,objectToMap.mTitle);
    }
}
