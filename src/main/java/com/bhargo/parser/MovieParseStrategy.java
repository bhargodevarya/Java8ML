package com.bhargo.parser;

import com.bhargo.model.BaseModel;

public class MovieParseStrategy extends AbstractParseStrategy {

    /**
     * Since movie name might have a comma in its name,
     * we need to parse it differently
     * @param line
     */
    @Override
    public BaseModel parse(String line) {
        if(!line.contains("\"")) {
            return super.parse(line);
        } else {
            // --TODO write the logic
            //System.out.println("Movie name has a comma");
            return null;
        }
    }
}
