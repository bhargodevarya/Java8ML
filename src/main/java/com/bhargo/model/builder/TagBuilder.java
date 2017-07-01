package com.bhargo.model.builder;

import com.bhargo.model.BaseModel;
import com.bhargo.model.Tag;

public class TagBuilder implements Builder<BaseModel> {

    public TagBuilder() {}

    @Override
    public BaseModel buildWithArr(String[] arr) {
        return new Tag(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]),
                arr[2], Long.valueOf(arr[3]));
    }
}
