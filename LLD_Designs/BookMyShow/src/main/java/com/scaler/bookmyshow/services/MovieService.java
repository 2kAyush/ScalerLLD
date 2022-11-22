package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.ActorNotFoundException;
import com.scaler.bookmyshow.models.Actor;
import com.scaler.bookmyshow.models.Language;
import com.scaler.bookmyshow.models.Movie;
import com.scaler.bookmyshow.models.MovieFeature;
import com.scaler.bookmyshow.repositories.ActorRepository;
import com.scaler.bookmyshow.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private ActorRepository actorRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    public Movie addMovie(String name, int length, double rating, List<MovieFeature> movieFeatures,
                          List<Language> languages, List<Long> actorId) throws ActorNotFoundException {
        List<Actor> actors = new ArrayList<>();
        for(Long id:actorId){
            Optional<Actor> actorOptional = actorRepository.findById(id);
            if(!actorOptional.isPresent()){
                throw new ActorNotFoundException("Provide correct Id");
            }
            actors.add(actorOptional.get());
        }
        Movie movie = new Movie();
        movie.setName(name);
        movie.setLength(length);
        movie.setRating(rating);
        movie.setActors(actors);
        movie.setMovieFeatures(movieFeatures);
        movie.setLanguages(languages);
        Movie savedMovie = movieRepository.save(movie);

        for(Actor actor:actors){
            actor.getMovies().add(savedMovie);
            actorRepository.save(actor);
        }

        return savedMovie;
    }
}
