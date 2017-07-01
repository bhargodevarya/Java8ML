package com.bhargo.parser;

import com.bhargo.model.builder.Builder;

public class MovieLensParser implements Parser<String> {

    /**
     * TODO - As per lambdas, I should be passing "how to parse" as argument
     * Parses a give line
     * @param line, the line to be parsed
     * @return
     */
    @Override
    public String parse(String line, ParseStrategy parseStrategy) {
        parseStrategy.parse(line);
        return null;
    }
}
