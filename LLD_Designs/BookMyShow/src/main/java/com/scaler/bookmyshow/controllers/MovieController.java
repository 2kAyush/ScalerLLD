package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.exceptions.ActorNotFoundException;
import com.scaler.bookmyshow.models.Language;
import com.scaler.bookmyshow.models.Movie;
import com.scaler.bookmyshow.models.MovieFeature;
import com.scaler.bookmyshow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public Movie addMovie(String name, int length, double rating, List<MovieFeature> movieFeatures,
                          List<Language> languages, List<Long> actorIds) {
        Movie movie = null;
        try {
            movie = movieService.addMovie(name, length, rating, movieFeatures, languages, actorIds);
        }
        catch (ActorNotFoundException e){
            System.out.println("Something went wrong" + e);
        }
        return  movie;
    }

}
