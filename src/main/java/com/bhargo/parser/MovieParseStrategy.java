package com.bhargo.parser;

public class MovieParseStrategy extends AbstractParseStrategy {

    /**
     * Since movie name might have a comma in its name,
     * we need to parse it differently
     * @param line
     */
    @Override
    public void parse(String line, String fileName) {
        if(!line.contains("\"")) {
            super.parse(line,fileName);
        } else {
            // --TODO write the logic
            System.out.println("Movie name has a comma");
        }

    }
}
