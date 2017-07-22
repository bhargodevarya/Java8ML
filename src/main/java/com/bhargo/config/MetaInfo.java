package com.bhargo.config;

import org.springframework.beans.factory.annotation.Value;

public class MetaInfo {

    @Value("${movie.col.num}")
    private int movieCol;

    @Value("${genomescore.col.num}")
    private int genomeScoreCol;

    @Value("${genometag.col.num}")
    private int genomeTagCol;

    @Value("${link.col.num}")
    private int linkCol;

    @Value("${rating.col.num}")
    private int ratingCol;

    @Value("${tag.col.num}")
    private int tagCol;

    @Value("${file.location}")
    private String fileLocation;

    public int getColumns(String fileName) {
        int result = 0;
        switch (fileName) {
            case "movies.csv" : result = movieCol;break;
            case "genome-scores.csv" : result = genomeScoreCol;break;
            case "genome-tags.csv" : result = genomeTagCol;break;
            case "ratings.csv" : result = ratingCol;break;
            case "tags.csv" : result = tagCol;break;
            case "links.csv" : result = linkCol;break;
        }
        if (result == 0) throw new IllegalArgumentException("Invalid file name");
        return result;
    }

    public String getFileLocation() {
        return fileLocation;
    }
}
