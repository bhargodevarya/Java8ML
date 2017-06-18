package com.bhargo.model;

import java.util.Objects;

public class Links {
    private String movieId;
    private String imdbId;
    private String tmdbId;

    public Links() {
    }

    public Links(String movieId, String imdbId, String tmdbId) {
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(String tmdbId) {
        this.tmdbId = tmdbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Links links = (Links) o;
        return Objects.equals(getMovieId(), links.getMovieId()) &&
                Objects.equals(getImdbId(), links.getImdbId()) &&
                Objects.equals(getTmdbId(), links.getTmdbId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieId(), getImdbId(), getTmdbId());
    }

    @Override
    public String toString() {
        return "Links{" +
                "movieId='" + movieId + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", tmdbId='" + tmdbId + '\'' +
                '}';
    }
}
