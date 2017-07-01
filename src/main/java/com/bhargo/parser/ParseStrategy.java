package com.bhargo.parser;

import com.bhargo.model.BaseModel;

@FunctionalInterface
public interface ParseStrategy {

    BaseModel parse(String line);
}
