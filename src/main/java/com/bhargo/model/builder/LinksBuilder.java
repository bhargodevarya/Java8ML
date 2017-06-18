package com.bhargo.model.builder;

import com.bhargo.Builder;
import com.bhargo.model.Links;
import org.springframework.stereotype.Service;

public class LinksBuilder implements Builder<Links> {

    public LinksBuilder() {}

    @Override
    public Links buildWithArr(String[] arr) {
        return new Links(arr[0], arr[1], arr[2]);
    }

    @Override
    public int getNumOfFields() {
        return 3;
    }
}
