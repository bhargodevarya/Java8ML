package com.bhargo.parser;

public class MovieParseStrategy extends AbstractParseStrategy {

    /**
     * Since movie name might have a comma in its name,
     * we need to parse it differently
     * @param line
     */
    @Override
    public void parse(String line) {
        if(!line.contains("\"")) {
            super.parse(line);
        } else {
            // --TODO write the logic
            System.out.println("Movie name has a comma");
        }

    }
}
