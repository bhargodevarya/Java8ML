package com.bhargo.model.builder;

import com.bhargo.model.Tag;

public class TagBuilder implements Builder<Tag> {

    public TagBuilder() {}

    @Override
    public int getNumOfFields() {
        return 4;
    }

    @Override
    public Tag buildWithArr(String[] arr) {
        return new Tag(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]),
                arr[2], Long.valueOf(arr[3]));
    }
}
