package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.City;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Override
    City save(City entity);

    @Override
    Optional<City> findById(Long ID);
}
