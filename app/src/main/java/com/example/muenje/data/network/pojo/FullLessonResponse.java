package com.example.muenje.data.network.pojo;

import com.google.firebase.database.PropertyName;

import java.util.ArrayList;
import java.util.List;

public class FullLessonResponse extends LessonTitleResponse {
    @PropertyName("bodies")
    public final List<String> bodies;

    public FullLessonResponse() {
        bodies = new ArrayList<>();
    }

    public FullLessonResponse(Integer id, String title, List<String> bodies) {
        super(id, title);
        this.bodies = bodies;
    }
}