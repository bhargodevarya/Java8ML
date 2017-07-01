package com.bhargo.model.builder;

import java.util.Map;

public class BuilderFactory {

    private Map<String, Builder> builderMap;

    public BuilderFactory() {
    }

    public Map<String, Builder> getBuilderMap() {
        return builderMap;
    }

    public void setBuilderMap(Map<String, Builder> builderMap) {
        this.builderMap = builderMap;
    }

    public Builder getBuilderFor(String fileName) {
        return builderMap.get(fileName);
    }
}
