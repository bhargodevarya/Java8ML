package com.bhargo.model.builder;

import com.bhargo.parser.*;
import com.bhargo.reader.Reader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;

public class Util {

    private final static File fileDir = new File("D:\\ml-20m");

    @Autowired
    private Parser parser;

    @Autowired
    private Reader reader;

    @Autowired
    private StandardParserStrategy standardParserStrategy;

    @Autowired
    private MovieParseStrategy movieParseStrategy;

    /**
     * This method initiates the init process
     */
    public void init() {
        Arrays.stream(fileDir.listFiles()).
                filter(n -> !n.getName().contains("txt") && n.getName().contains("movies")).
                forEach(this::startParse);
    }

    private void startParse(File file) {
        AbstractParseStrategy parseStrategy = file.getName().contains("movies") ?
                movieParseStrategy : standardParserStrategy;
        try {
            parseStrategy.setCurrentFile(file.getName());
            reader.readAsStream(file).forEach(l -> parse(l, parseStrategy));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parse(String line, ParseStrategy parseStrategy) {
        parser.parse(line, parseStrategy);
    }
}
