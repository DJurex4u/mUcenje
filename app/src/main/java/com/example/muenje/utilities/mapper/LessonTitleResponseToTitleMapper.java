package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.Title;
import com.example.muenje.data.network.pojo.LessonTitleResponse;

public class LessonTitleResponseToTitleMapper extends SimpleListMapper<LessonTitleResponse, Title> {
    @Override
    public Title map(LessonTitleResponse objectToMap) {
        return new Title(objectToMap.mId,objectToMap.mTitle);
    }
}
