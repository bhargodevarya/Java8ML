package com.bhargo.model.builder;

import com.bhargo.parser.Parser;
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

    /**
     * This method initiates the init process
     */
    public void init() {
        Arrays.stream(fileDir.listFiles()).
                filter(n -> !n.getName().contains("txt")).
                forEach(this::parse);
    }

    private void parse(File file) {
        try {
            reader.readAsStream(file).forEach(l -> {
                parser.parse(l, file.getName());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
