package com.bhargo;

import com.bhargo.model.builder.*;
import com.bhargo.parser.MovieLensParser;
import com.bhargo.parser.MovieParseStrategy;
import com.bhargo.parser.Parser;
import com.bhargo.parser.StandardParserStrategy;
import com.bhargo.reader.FileReader;
import com.bhargo.reader.Reader;
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
    public Reader reader() {
        return new FileReader();
    }

    @Bean
    public Parser parser() {
        return new MovieLensParser();
    }

    @Bean
    public MovieParseStrategy movieParseStrategy() {
        return new MovieParseStrategy();
    }

    @Bean
    public StandardParserStrategy standardParserStrategy() {
        return new StandardParserStrategy();
    }

    @Bean
    public BuilderFactory builderFactory() {
        BuilderFactory builderFactory = new BuilderFactory();
        Map<String, Builder> map = new HashMap<>();
        map.put("genome-scores.csv",genomeScoreBuilder());
        map.put("genome-tags.csv",genomeTagBuilder());
        map.put("links.csv", linksBuilder());
        map.put("movies.csv", movieBuilder());
        map.put("ratings.csv", ratingBuilder());
        map.put("tags.csv", tagBuilder());
        builderFactory.setBuilderMap(map);
        return builderFactory;
    }


}
