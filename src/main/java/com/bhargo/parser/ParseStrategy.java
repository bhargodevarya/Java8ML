package com.bhargo.parser;

import com.bhargo.model.builder.Builder;

@FunctionalInterface
public interface ParseStrategy {

    void parse(String line);

    /**
     * returns true if a line has all the fields to populate the model,
     * else false.
     * @param line, the line being read from a file
     * @return
     */
    default boolean hasEnoughFields(String line, Builder builder) {
        return line.split(",").length < builder.getNumOfFields();
    }
}
