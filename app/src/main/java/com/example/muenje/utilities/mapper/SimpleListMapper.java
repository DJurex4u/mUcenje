package com.example.muenje.utilities.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleListMapper<From,To> implements IMapper<From,To> {

    public List<To> mapList(List<From> listToMap){
        ArrayList<To> mappedList = new ArrayList<>();
        for (From objectToMap : listToMap) {
            mappedList.add(map(objectToMap));
        }
        return mappedList;
    }
}
