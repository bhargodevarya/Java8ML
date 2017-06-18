package com.bhargo.model;

import java.util.Objects;

public class Tag {

    private int userId;
    private int movieId;
    private String tag;
    private long timestamp;

    public Tag() {
    }

    public Tag(int userId, int movieId, String tag, long timestamp) {
        this.userId = userId;
        this.movieId = movieId;
        this.tag = tag;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
        Tag tag1 = (Tag) o;
        return getUserId() == tag1.getUserId() &&
                getMovieId() == tag1.getMovieId() &&
                getTimestamp() == tag1.getTimestamp() &&
                Objects.equals(getTag(), tag1.getTag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getMovieId(), getTag(), getTimestamp());
    }

    @Override
    public String toString() {
        return "Tag{" +
                "userId=" + userId +
                ", movieId=" + movieId +
                ", tag='" + tag + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
