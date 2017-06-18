package com.bhargo;

import com.bhargo.model.builder.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    public Util util() {
        return new Util();
    }

    @Bean
    public GenomeScoreBuilder genomeScoreBuilder() {
        return new GenomeScoreBuilder();
    }

    @Bean
    public GenomeTagBuilder genomeTagBuilder() {
        return new GenomeTagBuilder();
    }

    @Bean
    public LinksBuilder linksBuilder() {
        return new LinksBuilder();
    }

    @Bean
    public MovieBuilder movieBuilder() {
        return new MovieBuilder();
    }

    @Bean
    public RatingBuilder ratingBuilder() {
        return new RatingBuilder();
    }

    @Bean
    public TagBuilder tagBuilder() {
        return new TagBuilder();
    }

    @Bean
    public BuilderFactory builderFactory() {
        BuilderFactory builderFactory = new BuilderFactory();
        Map<String, Builder> map = new HashMap<>();
        map.put("genome-scores.csv",genomeScoreBuilder());
        map.put("genome-Tags.csv",genomeTagBuilder());
        map.put("links.csv", linksBuilder());
        map.put("movies.csv", movieBuilder());
        map.put("ratings", ratingBuilder());
        map.put("tags.csv", tagBuilder());
        builderFactory.setBuilderMap(map);
        return builderFactory;
    }


}
