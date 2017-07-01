package com.bhargo.model;

import java.util.Objects;

public class GenomeTag implements BaseModel {

    private String tagId;
    private String tag;

    public GenomeTag() {
    }

    public GenomeTag(String tagId, String tag) {
        this.tagId = tagId;
        this.tag = tag;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenomeTag tags = (GenomeTag) o;
        return Objects.equals(getTagId(), tags.getTagId()) &&
                Objects.equals(getTag(), tags.getTag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTagId(), getTag());
    }

    @Override
    public String toString() {
        return "GenomeTag{" +
                "tagId='" + tagId + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
