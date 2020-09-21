package com.example.muenje.data.entities;

import java.util.List;

public class FullLesson extends Title {

    final List<String> mBodies;

    public FullLesson(int id, String mHeader, List<String> bodies){
        super(id,mHeader);
        mBodies = bodies;
    }

    public List<String> getFullLesons(){
        return mBodies;
    }

    public String getSingleBody(Integer index){
        return mBodies.get(index);
    }
}
