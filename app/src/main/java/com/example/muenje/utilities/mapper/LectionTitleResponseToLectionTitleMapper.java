package com.example.muenje.utilities.mapper;

import com.example.muenje.data.entities.LectionTitle;
import com.example.muenje.data.network.pojo.LectionTitleResponse;

public class LectionTitleResponseToLectionTitleMapper extends SimpleListMapper<LectionTitleResponse, LectionTitle> {
    @Override
    public LectionTitle map(LectionTitleResponse objectToMap) {
        return new LectionTitle(objectToMap.mId,objectToMap.mTitle);
    }
}
