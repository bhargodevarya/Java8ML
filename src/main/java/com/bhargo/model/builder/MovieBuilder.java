package com.bhargo.model.builder;

import com.bhargo.model.Movie;

public class MovieBuilder implements Builder<Movie> {

    public MovieBuilder() {
    }

    @Override
    public int getNumOfFields() {
        return 3;
    }

    @Override
    public Movie buildWithArr(String[] arr) {
        return new Movie(Integer.valueOf(arr[0]), arr[1], arr[2]);
    }
}
