package com.bhargo.model.builder;

import com.bhargo.model.BaseModel;
import com.bhargo.model.MovieLens;

import java.util.List;

public class MovieLensBuilder {

    private MovieLens movieLens = new MovieLens();

    public MovieLens build(String fileName, List<BaseModel> list) {
        switch (fileName) {
            case"movies.csv":movieLens.setMovies(list);break;
            case"tags.csv":movieLens.setTags(list);break;
            case"links.csv":movieLens.setLinks(list);break;
            case"ratings.csv":movieLens.setRatings(list);break;
            case"genome-scores.csv":movieLens.setGenomeScores(list);break;
            case"genome-tags.csv":movieLens.setGenomeTags(list);break;
        }
        return movieLens;
    }
}
