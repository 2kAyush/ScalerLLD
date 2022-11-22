package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Override
    Seat save(Seat seat);
}
