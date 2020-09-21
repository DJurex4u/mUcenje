package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.FullLesson;
import com.example.muenje.data.network.pojo.FullLessonResponse;

public class FullLessonResponseToFullLessonMapper implements IMapper<FullLessonResponse, FullLesson> {
    @Override
    public FullLesson map(FullLessonResponse objectToMap) {
        return new FullLesson(objectToMap.mId,objectToMap.mTitle,objectToMap.bodies);
    }
}
