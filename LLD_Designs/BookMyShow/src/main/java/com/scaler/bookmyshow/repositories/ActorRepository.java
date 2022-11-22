package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Override
    Actor save(Actor actor);

    @Override
    Optional<Actor> findById(Long actorId);
}
