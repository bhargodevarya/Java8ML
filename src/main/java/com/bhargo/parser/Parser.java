package com.bhargo.parser;

@FunctionalInterface
public interface Parser<T> {

    <T> T parse(String line, ParseStrategy parseStrategy);

}
