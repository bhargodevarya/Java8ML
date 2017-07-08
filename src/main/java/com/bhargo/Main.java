package com.bhargo;

import com.bhargo.model.builder.*;
import com.bhargo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private Util util;

    @Autowired
    private MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(movieService.howToUseReduce());
        //System.out.println(movieService.groupMoviesByYear());
    }
}
