package com.bhargo.parser;

import com.bhargo.Builder;
import com.bhargo.model.builder.BuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieLensParser implements Parser<String> {

    @Autowired
    private BuilderFactory builderFactory;

    /**
     * TODO - As per lambdas, I should be passing "how to pass" as argument
     * Parses a give line
     * @param line, the line to be parsed
     * @param fileName, the file name the line is in
     * @return
     */
    @Override
    public String parse(String line, String fileName) {
        Builder builder = builderFactory.getBuilderFor(fileName);
        if(!line.contains("\"")) {
            if(!hasEnoughFields(line, builder)) {
                String[] arr = new String[builder.getNumOfFields()];
                for(int i =0;i<arr.length;i++) {
                    if(i <= line.split(",").length-1) {
                        arr[i] = line.split(",")[i];
                    } else {
                        arr[i] = null;
                    }
                }
                //System.out.println(builder.buildWithArr(arr));
            } else {
                //System.out.println(builder.buildWithArr(line.split(",")));
            }
        }
        //TODO, movies.csv file has comma in the movie name
        else {

        }
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
