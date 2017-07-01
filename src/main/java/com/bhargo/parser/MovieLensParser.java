package com.bhargo.parser;

import com.bhargo.model.builder.Builder;

public class MovieLensParser implements Parser<String> {

    /**
     * TODO - As per lambdas, I should be passing "how to parse" as argument
     * Parses a give line
     * @param line, the line to be parsed
     * @param fileName, the file name the line is in
     * @return
     */
    @Override
    public String parse(String line, String fileName, ParseStrategy parseStrategy) {
        parseStrategy.parse(line, fileName);
        return null;
    }

    /**
     * returns true if a line has all the fields to populate the model,
     * else false.
     * @param line, the line being read from a file
     * @return
     */
    private boolean hasEnoughFields(String line, Builder builder) {
        return line.split(",").length < builder.getNumOfFields();
    }
}
