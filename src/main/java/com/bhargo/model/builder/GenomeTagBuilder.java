package com.bhargo.model.builder;

import com.bhargo.Builder;
import com.bhargo.model.GenomeTag;

public class GenomeTagBuilder implements Builder<GenomeTag>{

    public GenomeTagBuilder() {
    }

    @Override
    public GenomeTag buildWithArr(String[] arr) {
        return new GenomeTag(arr[0], arr[1]);
    }

    @Override
    public int getNumOfFields() {
        return 2;
    }
}
