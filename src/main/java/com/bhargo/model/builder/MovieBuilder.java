package com.bhargo.model.builder;

import com.bhargo.model.BaseModel;
import com.bhargo.model.Movie;

public class MovieBuilder implements Builder<BaseModel> {

    public MovieBuilder() {
    }

    @Override
    public BaseModel buildWithArr(String[] arr) {
        return new Movie(Integer.valueOf(arr[0]), arr[1], arr[2]);
    }
}
