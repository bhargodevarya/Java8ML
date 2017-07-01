package com.bhargo.parser;

public class StandardParserStrategy extends AbstractParseStrategy {

    /**
     * TODO -- remove Builderfactory and fileName
     * after moving numOfFields to properties file
     * @param line, line to be parsed
     * @param fileName file name to get the builder for
     */
    @Override
    public void parse(String line, String fileName) {
        super.parse(line, fileName);
    }
}
