package com.bhargo.model;

import java.util.Objects;

public class Rating {

    private int userId;
    private int movieId;
    private float rating;
    private long timestamp;

    public Rating() {
    }

    public Rating(int userId, int movieId, float rating, long timestamp) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return getUserId() == rating1.getUserId() &&
                getMovieId() == rating1.getMovieId() &&
                Float.compare(rating1.getRating(), getRating()) == 0 &&
                getTimestamp() == rating1.getTimestamp();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getMovieId(), getRating(), getTimestamp());
    }

    @Override
    public String toString() {
        return "Rating{" +
                "userId=" + userId +
                ", movieId=" + movieId +
                ", rating=" + rating +
                ", timestamp=" + timestamp +
                '}';
    }
}
