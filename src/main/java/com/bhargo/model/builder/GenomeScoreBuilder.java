package com.bhargo.model.builder;

import com.bhargo.model.BaseModel;
import com.bhargo.model.GenomeScore;

public class GenomeScoreBuilder implements Builder<BaseModel> {

    public GenomeScoreBuilder() {
    }

    @Override
    public BaseModel buildWithArr(String[] arr) {
        return new GenomeScore(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]), Float.valueOf(arr[2]));
    }
}
