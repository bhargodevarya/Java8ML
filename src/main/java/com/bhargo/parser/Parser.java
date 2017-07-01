package com.bhargo.parser;

public interface Parser<T> {

    T parse(String line, String fileName);
}
