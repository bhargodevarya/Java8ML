package com.bhargo.model.builder;

import com.bhargo.model.BaseModel;
import com.bhargo.model.MovieLens;
import com.bhargo.parser.*;
import com.bhargo.reader.Reader;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    private MovieLensBuilder movieLensBuilder;

    /**
     * This method initiates the parse process
     */
    public MovieLens init() {
        MovieLens movieLens = new MovieLens();
        for(File file:fileDir.listFiles()) {
            if(!file.getName().contains("txt")) {
                movieLens = movieLensBuilder.build(file.getName(), startParse(file));
            }
        }
        return movieLens;
    }

    private List<BaseModel> startParse(File file) {
        List<BaseModel> list = new ArrayList<>();
        AbstractParseStrategy parseStrategy = file.getName().contains("movie") || (!file.getName().contains("-") && file.getName().contains("tags")) ?
                movieParseStrategy : standardParserStrategy;
        try {
            parseStrategy.setCurrentFile(file.getName());
            list = reader.readAsStream(file).
                    map(l -> parse(l, parseStrategy)).
                    collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private BaseModel parse(String line, ParseStrategy parseStrategy) {
        return (BaseModel)parser.parse(line, parseStrategy);
    }
}