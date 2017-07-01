package com.bhargo.model.builder;

import com.bhargo.parser.MovieParseStrategy;
import com.bhargo.parser.ParseStrategy;
import com.bhargo.parser.Parser;
import com.bhargo.parser.StandardParserStrategy;
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
        ParseStrategy parseStrategy = file.getName().contains("movies") ?
                movieParseStrategy : standardParserStrategy;
        try {
            reader.readAsStream(file).forEach(l -> parse(l, file, parseStrategy));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parse(String line, File file, ParseStrategy parseStrategy) {
        parser.parse(line, file.getName(), parseStrategy);
    }
}
