package com.bhargo.model.builder;

import com.bhargo.model.Rating;

public class RatingBuilder implements Builder<Rating> {

    public RatingBuilder() {}

    @Override
    public int getNumOfFields() {
        return 4;
    }

    @Override
    public Rating buildWithArr(String[] arr) {
        return new Rating(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]),
                Float.valueOf(arr[2]), Long.valueOf(arr[3]));
    }
}
