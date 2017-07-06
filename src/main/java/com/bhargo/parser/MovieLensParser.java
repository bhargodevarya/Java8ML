package com.bhargo.parser;

import com.bhargo.model.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class MovieLensParser implements Parser<BaseModel> {

    /**
     * TODO - As per lambdas, I should be passing "how to parse" as argument
     * Parses a give line
     * @param line, the line to be parsed
     * @return
     */
    @Override
    public BaseModel parse(String line, ParseStrategy parseStrategy) {
        return parseStrategy.parse(line);
    }
}
