package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    ShowSeat save(ShowSeat entity);

//    @Override
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    Optional<ShowSeat> findById(Long Id); // not required

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({
            @QueryHint(name="javax.persistence.lock.timeout", value = "30000")
            // this will allow the second transaction to wait 30 seconds (max time it will wait)before returning
    })
    List<ShowSeat> findByIdIn(List<Long> ids);

    //    List<ShowSeat> findByIdIn(List<Long> showSeatIds);
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    List<ShowSeat> findByIdIn(List<Long> showSeatIds);
}

