package com.scaler.splitwise.repositories;

import com.scaler.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long aLong);
}
