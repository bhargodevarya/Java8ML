package com.bhargo.model.builder;

import com.bhargo.Builder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Util {

    private final static File fileDir = new File("D:\\ml-20m");

    @Autowired
    private BuilderFactory builderFactory;


    public void getFiles () {
        System.out.println(builderFactory == null);
        Builder[] builder = new Builder[1];
        Arrays.stream(fileDir.listFiles()).filter(n -> !n.getName().contains("txt") && n.getName().contains("links"))
                .forEach(f ->{
                    builder[0] = builderFactory.getBuilderFor(f.getName());
                    try {
                        Files.lines(Paths.get(f.getAbsolutePath())).skip(1).forEach(l -> {
                            if(!containsQuote(l)) {
                                if(l.split(",").length < builder[0].getNumOfFields()) {
                                    String[] arr = new String[builder[0].getNumOfFields()];
                                    for(int i =0;i<arr.length;i++) {
                                        if(i <= l.split(",").length-1) {
                                            arr[i] = l.split(",")[i];
                                        } else {
                                            arr[i] = null;
                                        }
                                    }
                                    System.out.println(builder[0].buildWithArr(arr));
                                } else{
                                    System.out.println(builder[0].buildWithArr(l.split(",")));
                                }
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    private boolean containsQuote(String line) {
        return line.contains("\"");
    }
}
