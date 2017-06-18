package com.bhargo.model.builder;

import com.bhargo.Builder;
import com.bhargo.model.GenomeScore;

public class GenomeScoreBuilder implements Builder<GenomeScore> {

    public GenomeScoreBuilder() {
    }

    @Override
    public int getNumOfFields() {
        return 3;
    }

    @Override
    public GenomeScore buildWithArr(String[] arr) {
        return new GenomeScore(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]), Float.valueOf(arr[2]));
    }
}
