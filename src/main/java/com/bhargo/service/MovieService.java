package com.bhargo.service;

import com.bhargo.model.Movie;
import com.bhargo.model.MovieLens;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
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
    public void distinctGenres(){
        movieLens.getMovies().stream().filter(n -> n!=null).
                map(m -> ((Movie)m).getGenres().split("\\|")).
                flatMap(a -> Arrays.stream(a)).distinct().forEach(System.out::println);
    }

    /**
     * reduce(t1,t1 -> t3)
     * performs a reduction ops on all the elements of a stream and returns a single value
     * This operation is of type {@link java.util.function.BinaryOperator}
     * @see Stream#reduce(BinaryOperator)
     * @return
     */
    public Optional<Integer> howToUseReduce() {
        return movieLens.getMovies().stream().
                filter(n -> n!=null).map(m ->((Movie)m).getMovieId()).
                reduce((a,b) -> a+b);
    }

}
