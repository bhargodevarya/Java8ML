package com.bhargo.service;

import com.bhargo.BaseTest;
import com.bhargo.model.Movie;
import com.bhargo.model.MovieLens;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
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
}
