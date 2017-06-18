package com.bhargo.model;

import com.bhargo.Builder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GenomeScore {
    private int movieId;
    private int tagId;
    private float relevance;

    public GenomeScore() {
    }

    public GenomeScore(int movieId, int tagId, float relevance) {
        this.movieId = movieId;
        this.tagId = tagId;
        this.relevance = relevance;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public float getRelevance() {
        return relevance;
    }

    public void setRelevance(float relevance) {
        this.relevance = relevance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenomeScore that = (GenomeScore) o;
        return getMovieId() == that.getMovieId() &&
                getTagId() == that.getTagId() &&
                Float.compare(that.getRelevance(), getRelevance()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieId(), getTagId(), getRelevance());
    }

    @Override
    public String toString() {
        return "GenomeScore{" +
                "movieId=" + movieId +
                ", tagId=" + tagId +
                ", relevance=" + relevance +
                '}';
    }
}
