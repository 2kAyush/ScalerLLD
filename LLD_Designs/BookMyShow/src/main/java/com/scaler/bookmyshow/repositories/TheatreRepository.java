package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    @Override
    Theatre save(Theatre theatre);

    @Override
    Optional<Theatre> findById(Long aLong);
}
