package com.bhargo.model;

import java.util.List;

public class MovieLens {

    private List<? super Movie> movies;
    private List<? super Links> links;
    private List<? super Rating> ratings;
    private List<? super Tag> tags;
    private List<? super GenomeScore> genomeScores;
    private List<? super GenomeTag> genomeTags;

    public MovieLens() {
    }

    public MovieLens(List<? super Movie> movies, List<? super Links> links, List<? super Rating> ratings, List<? super Tag> tags, List<? super GenomeScore> genomeScores, List<? super GenomeTag> genomeTags) {
        this.movies = movies;
        this.links = links;
        this.ratings = ratings;
        this.tags = tags;
        this.genomeScores = genomeScores;
        this.genomeTags = genomeTags;
    }

    public List<? super Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<? super Movie> movies) {
        this.movies = movies;
    }

    public List<? super Links> getLinks() {
        return links;
    }

    public void setLinks(List<? super Links> links) {
        this.links = links;
    }

    public List<? super Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<? super Rating> ratings) {
        this.ratings = ratings;
    }

    public List<? super Tag> getTags() {
        return tags;
    }

    public void setTags(List<? super Tag> tags) {
        this.tags = tags;
    }

    public List<? super GenomeScore> getGenomeScores() {
        return genomeScores;
    }

    public void setGenomeScores(List<? super GenomeScore> genomeScores) {
        this.genomeScores = genomeScores;
    }

    public List<? super GenomeTag> getGenomeTags() {
        return genomeTags;
    }

    public void setGenomeTags(List<? super GenomeTag> genomeTags) {
        this.genomeTags = genomeTags;
    }

    public void setupComplete() {
        System.out.printf("movies is %d, links is %d, " +
                "ratings is %d, tags in %d, " +
                "genomescore is %d, genometags is %d",
                movies.size(), links.size(), ratings.size(), tags.size(), genomeScores.size(), genomeTags.size());
    }
}
