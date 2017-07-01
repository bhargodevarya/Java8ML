package com.bhargo.model.builder;

import com.bhargo.model.BaseModel;
import com.bhargo.model.Links;

public class LinksBuilder implements Builder<BaseModel> {

    public LinksBuilder() {}

    @Override
    public BaseModel buildWithArr(String[] arr) {
        return new Links(arr[0], arr[1], arr[2]);
    }
}
