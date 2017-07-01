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
    public List<BaseModel> parse(String line, ParseStrategy parseStrategy) {
        List<BaseModel> list = new ArrayList<>();
        list.add(parseStrategy.parse(line));
        return list;
    }
}
