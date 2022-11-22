package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.AuditoriumNotFoundException;
import com.scaler.bookmyshow.exceptions.TheatreNotFoundException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.AuditoriumRepository;
import com.scaler.bookmyshow.repositories.SeatRepository;
import com.scaler.bookmyshow.repositories.TheatreRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AuditoriumService {
    private AuditoriumRepository auditoriumRepository;
    private TheatreRepository theatreRepository;
    private SeatRepository seatRepository;

    @Autowired
    public AuditoriumService(AuditoriumRepository auditoriumRepository, TheatreRepository theatreRepository,
                             SeatRepository seatRepository) {
        this.auditoriumRepository = auditoriumRepository;
        this.theatreRepository = theatreRepository;
        this.seatRepository = seatRepository;
    }


    public Auditorium createAudi(String name, int capacity, List<AuditoriumFeature> auditoriumFeatures, Long theatreId) throws TheatreNotFoundException{
        Optional<Theatre> theatreOptional = theatreRepository.findById(theatreId);
        if(!theatreOptional.isPresent()){
            throw new TheatreNotFoundException("Provide correct theatre Id");
        }
        Theatre theatreDb = theatreOptional.get();
        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        auditorium.setCapacity(capacity);
        auditorium.setAuditoriumFeatures(auditoriumFeatures);
//        auditorium.setSeats(new ArrayList<>(capacity)); // can add here if in future we decide to it
        auditorium.setTheatre(theatreDb);
        Auditorium savedAuditorium =  auditoriumRepository.save(auditorium);

        theatreDb.getAuditoriums().add(savedAuditorium);
        theatreRepository.save(theatreDb);

        return savedAuditorium;
    }

    /**
     *
     * @param auditoriumId :-> seats to be added for.
     * @param seatCount :-> map to store the seatType and seat number.
     * @throws AuditoriumNotFoundException
     */
    public void addSeats(Long auditoriumId, Map<SeatType, Integer> seatCount) throws AuditoriumNotFoundException {
        Optional<Auditorium> auditoriumOptional = auditoriumRepository.findById(auditoriumId);
        if(!auditoriumOptional.isPresent()){
            throw new AuditoriumNotFoundException("Audi not found");
        }
        Auditorium auditorium = auditoriumOptional.get();

        List<Seat> seats = new ArrayList<>();
        for(Map.Entry<SeatType, Integer> entry: seatCount.entrySet()) {
            for(int i = 0;i < entry.getValue();++i) {
                Seat seat = new Seat();
                seat.setSeatType(entry.getKey());
                seat.setSeatNumber(entry.getKey().toString() + "_" + (i + 1));
                seats.add(seat);
            }
        }

        List<Seat> savedSeats = new ArrayList<>();
        for(Seat seat:seats) {
            savedSeats.add(seatRepository.save(seat));
        }

        auditorium.setSeats(savedSeats);

        auditoriumRepository.save(auditorium);
    }


}
