package com.bhargo.parser;

import com.bhargo.config.MetaInfo;
import com.bhargo.model.BaseModel;
import com.bhargo.model.builder.Builder;
import com.bhargo.model.builder.BuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractParseStrategy implements ParseStrategy {

    @Autowired
    private BuilderFactory builderFactory;

    @Autowired
    private MetaInfo metaInfo;

    private String currentFile;

    public void setCurrentFile(String currentFile) {
        this.currentFile = currentFile;
    }

    /**
     * returns true if a line has all the fields to populate the model,
     * else false.
     * @param line, the line being read from a file
     * @return
     */
    protected boolean hasEnoughFields(String line) {
        return line.split(",").length ==
                metaInfo.getColumns(currentFile);
    }

    @Override
    public BaseModel parse(String line) {
        Builder builder = getBuilderFor(currentFile);
        if(!hasEnoughFields(line)) {
            String[] arr = new String[metaInfo.getColumns(currentFile)];
            for(int i =0;i<arr.length;i++) {
                if(i <= line.split(",").length-1) {
                    arr[i] = line.split(",")[i];
                }
                else {
                    arr[i] = null;
                }
            }
            return (BaseModel) builder.buildWithArr(arr);
        } else {
            return (BaseModel) builder.buildWithArr(line.split(","));
        }
    }

    protected Builder getBuilderFor(String fileName) {
        return builderFactory.getBuilderFor(fileName);
    }
}
