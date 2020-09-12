package com.example.muenje.data.entities;

import java.util.ArrayList;

public class LectionFull extends LectionTitle {

    final ArrayList<String> mBodies;

    public LectionFull(int id, String mHeader, ArrayList<String> bodies){
        super(id,mHeader);
        //warrning: shallow copy
        mBodies = bodies;
    }
}
