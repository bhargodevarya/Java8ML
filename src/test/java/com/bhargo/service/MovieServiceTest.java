package com.bhargo.service;

import com.bhargo.BaseTest;
import com.bhargo.model.Movie;
import com.bhargo.model.MovieLens;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieServiceTest extends BaseTest{

    @Mock
    private MovieLens movieLens;

    @InjectMocks
    private MovieService movieService;

    @Before
    public void setUp() {
        movieService = new MovieService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDistinctGenresSuccess() {
        Mockito.when(movieLens.getMovies()).
                thenReturn(Stream.of(new Movie(1,"","Action|Drama|Comedy"),
                        new Movie(2,"","Comedy|Adventure")).
                        collect(Collectors.toList()));
        List<String> genres = movieService.distinctGenres();
        Assert.assertThat("genres should be " + genres,
                genres,
                IsIterableContainingInAnyOrder.
                        containsInAnyOrder("Action","Drama","Comedy","Adventure"));
    }

    @Test
    public void testCountMoviesByYear() {
        Mockito.when(movieLens.getMovies()).
                thenReturn(Stream.of(new Movie(1,"abc (1988)",""),
                        new Movie(2,"def (1947)",""),
                        new Movie(2,"xyz (1988)","")).
                        collect(Collectors.toList()));
        Map<String, Long> map = movieService.countMoviesByyear();
        Assert.assertThat(map, IsMapContaining.hasEntry("1947",1L));
        Assert.assertThat(map, IsMapContaining.hasEntry("1988",2L));
    }

    @Test
    public void testGroupMovieByYear() {
        Mockito.when(movieLens.getMovies()).
                thenReturn(Stream.of(new Movie(1,"abc (1988)",""),
                        new Movie(2,"def (1947)",""),
                        new Movie(3,"xyz (1988)","")).
                        collect(Collectors.toList()));
        Map<String,List<Movie>> actual = movieService.groupMoviesByYear();
        Assert.assertThat(actual, IsMapContaining.hasKey("1947"));
        List<Movie> list1 = actual.get("1988");
        Assert.assertEquals(2, list1.size());
    }
}
