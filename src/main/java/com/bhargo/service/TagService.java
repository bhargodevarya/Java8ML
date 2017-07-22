package com.bhargo.service;

import com.bhargo.model.Movie;
import com.bhargo.model.MovieLens;
import com.bhargo.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TagService {

    @Autowired
    private MovieLens movieLens;

    //TODO try collectingAndThen
    public Map<String,HashSet<String>> groupMoviesByTag() throws IOException {
        //to get <tag, List<Tag>>
        Map<String, List<Tag>> map = movieLens.getTags().stream().
                filter(t -> t != null).map(m -> (Tag) m).
                collect(Collectors.groupingBy(g -> {
                    return g.getTag();
                }));
        //to get <tag, Set<movie_name>>
        Map<String, HashSet<String>> map2 = movieLens.getTags().stream().
                filter(t -> t != null).map(m -> (Tag) m).
                collect(Collectors.
                        groupingBy((Tag g) -> g.getTag(),
                                Collector.of(() -> new HashSet<String>(), (h, q) -> {
                                            String title = movieLens.getMovies().
                                                    stream().filter(f -> f != null).
                                                    map(m -> (Movie) m).
                                                    filter(n -> n.getMovieId() == q.getMovieId()).
                                                    findAny().
                                                    orElseGet(() -> new Movie(0, "NOT A MOVIE", "")).
                                                    getTitle();
                                            h.add(title);
                                        },
                                        (h1, h2) -> {
                                            h1.addAll(h2); return h1;
                                        })));

        //map.entrySet().stream().forEach(e -> System.out.println("key is " +e.getKey() + " value is " + e.getValue()));
        map2.entrySet().stream().forEach(System.out::println);
        return map2;
    }


    public void groupMoviesByTagsUsers() {
        Map<String, Map<Integer, List<Tag>>> map = movieLens.getTags().stream().filter(n -> n!=null).map(m -> (Tag)m).
                collect(Collectors.groupingBy(Tag::getTag,Collectors.groupingBy(Tag::getUserId)));
        /*Map<String, Set<Tag>> map2 = movieLens.getTags().stream().filter(n -> n!=null).map(m -> (Tag)m).
                collect(Collectors.groupingBy(g -> g.getTag(),Collectors.toSet()));*/
        map.entrySet().stream().forEach(System.out::println);
    }

    //TODO get user with maximum tags
    //TODO get the tag most frequently created
}
