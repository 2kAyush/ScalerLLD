package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Override
    Movie save(Movie entity);

    @Override
    Optional<Movie> findById(Long aLong);
}
