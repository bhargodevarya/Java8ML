package com.bhargo.model.builder;

import com.bhargo.model.BaseModel;
import com.bhargo.model.GenomeTag;

public class GenomeTagBuilder implements Builder<BaseModel>{

    public GenomeTagBuilder() {
    }

    @Override
    public BaseModel buildWithArr(String[] arr) {
        return new GenomeTag(arr[0], arr[1]);
    }
}
