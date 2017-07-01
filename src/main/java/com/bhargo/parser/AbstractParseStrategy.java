package com.bhargo.parser;

import com.bhargo.config.MetaInfo;
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

    @Override
    public void parse(String line) {
        Builder builder = getBuilderFor(currentFile);
        if(!hasEnoughFields(line, builder)) {
            String[] arr = new String[builder.getNumOfFields()];
            for(int i =0;i<arr.length;i++) {
                if(i <= line.split(",").length-1) {
                    arr[i] = line.split(",")[i];
                }
                else {
                    arr[i] = null;
                }
            }
            //System.out.println(builder.buildWithArr(arr));
        } else {
            //System.out.println(builder.buildWithArr(line.split(",")));
        }
    }

    protected Builder getBuilderFor(String fileName) {
        return builderFactory.getBuilderFor(fileName);
    }
}
