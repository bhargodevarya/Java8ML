package com.bhargo.parser;

import java.util.List;

@FunctionalInterface
public interface Parser<T> {

    List<T> parse(String line, ParseStrategy parseStrategy);

}
