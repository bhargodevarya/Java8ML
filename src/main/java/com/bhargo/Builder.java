package com.bhargo;

public interface Builder<T> {
    int getNumOfFields();
    T buildWithArr(String[] arr);
}
