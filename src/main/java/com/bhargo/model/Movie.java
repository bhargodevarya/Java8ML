package com.bhargo.model;

import java.util.Objects;

public class Movie {

    private int movieId;
    private String title;
    private String genres;

    public Movie() {
    }

    public Movie(int movieId, String title, String genres) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getMovieId() == movie.getMovieId() &&
                Objects.equals(getTitle(), movie.getTitle()) &&
                Objects.equals(getGenres(), movie.getGenres());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieId(), getTitle(), getGenres());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
