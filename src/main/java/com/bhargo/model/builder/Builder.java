package com.bhargo.model.builder;

public interface Builder<T> {
    int getNumOfFields();
    T buildWithArr(String[] arr);
}
