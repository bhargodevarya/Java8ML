package com.bhargo.service;

import com.bhargo.model.Movie;
import com.bhargo.model.MovieLens;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieService {

    @Autowired
    private MovieLens movieLens;

    /**
     * filter(t -> Boolean)
     * it takes {@link java.util.function.Predicate}
     * replaces if conditions inside a for statement in earlier versions
     * for(T t:any list of T) {
     *     if(some condition)
     * } chages to list<T>.stream().filter(t -> <>some condition)
     * @see Stream#filter(Predicate)
     * NOTE:- its not possible to access elements that dont match the criteria
     *
     * map(T -> R)
     * it takes {@link java.util.function.Function}
     * a function takes a param of type A and resturns a result of type B
     * map is used to perform transformation, here a stream of {@link com.bhargo.model.Movie}
     * is transformed into a stream of String[]
     * @see Stream#map(Function)
     *
     * flatMap(T -> R)
     * it takes {@link java.util.function.Function}
     * flatmap is used to decompose the incoming stream, and then recomposes it
     * @see Stream#flatMap(Function)
     *
     * distinct()
     * produces distinct items of a stream
     * @see Stream#distinct()
     */
    public List<String> distinctGenres(){
        return movieLens.getMovies().stream().filter(n -> n!=null).
                map(m -> ((Movie)m).getGenres().split("\\|")).
                flatMap(a -> Arrays.stream(a)).distinct().collect(Collectors.toList());
    }

    /**
     * reduce(t1,t1 -> t3)
     * performs a reduction ops on all the elements of a stream and returns a single value
     * This operation is of type {@link java.util.function.BinaryOperator}
     * @see Stream#reduce(BinaryOperator)
     * @return
     */
    public Optional<Integer> howToUseReduce() {
        //doing the same using collectors
        /*movieLens.getMovies().stream().filter(n -> n!=null).
                map(m ->((Movie)m)).
                collect(Collectors.reducing(0,Movie::getMovieId, (a,b)->a+b)).
                intValue();*/
        return movieLens.getMovies().stream().
                filter(m -> m!=null).
                map(n -> ((Movie)n).getMovieId()).
                //there is another version of reduce that takes an init value as well
                reduce((a,b) -> a+b);
    }

    /**
     * This version of reduce is to used for parallel streams
     * reduce(init_value,accumulator,combiner)
     * accumulator runs on two argumetns and performs transformations
     * since more than 1 are being run in parallel,
     * you need a combiner that combines the result once all of them are done
     * {@link Stream#reduce(Object, BiFunction, BinaryOperator)}
     */
    private void collectorsToListUsingReduce() {
        Stream.of(1,2,3,4,5,6,7).
                        reduce(new ArrayList<>(),
                        (List<Integer> l, Integer a) -> {
                            l.add(a);
                            return l;
                        }, (List<Integer> l1, List<Integer> l2) -> {
                            System.out.println("l1 is" + l1 + "l2 is " + l2);
                            l1.addAll(l2);
                            return l1;
                        }).forEach(System.out::println);
    }

    private String getYear(String movieName) {
        return movieName.substring(movieName.lastIndexOf("(")+1,movieName.lastIndexOf(")"));
    }

    private boolean movieFilterCriteria(Movie movie) {
        return movie.getTitle() != null && movie.getTitle().contains("(") && movie.getTitle().contains(")");
    }

    /**
     * groupingBy(t -> r)
     * this function takes a function which accepts param of type A and returns param of type B
     * {@link Collectors#groupingBy(Function)}
     * @return
     */
    public Map<String, List<Movie>> groupMoviesByYear() {
        //a custom collector
        //Collector.of(HashSet::new,HashSet::add,(s1,s2) ->{s2.addAll(s2);return s2;}, Collector.Characteristics.UNORDERED);

        //to get Map<String, set<Movie>>
        /*Map<String, Set<Movie>> set = movieLens.getMovies().stream().filter(n -> n!=null).map(n -> ((Movie)n)).
                filter(this::movieFilterCriteria).
                collect(Collectors.groupingBy((Movie movie) ->
                        getYear(movie.getTitle()),Collectors.mapping(x -> x, Collectors.toSet())
                ));*/
        return movieLens.getMovies().stream().filter(n -> n!=null).map(n -> ((Movie)n)).
                filter(this::movieFilterCriteria).
                collect(Collectors.groupingBy((Movie movie) ->
                     getYear(movie.getTitle())
                ));
    }

}
