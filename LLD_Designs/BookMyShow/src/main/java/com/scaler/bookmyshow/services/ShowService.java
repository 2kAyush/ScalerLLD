package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShowService {
    private ShowRepository showRepository;
    private AuditoriumRepository auditoriumRepository;
    private MovieRepository movieRepository;
    private TheatreRepository theatreRepository;
    private ShowSeatRepository showSeatRepository;

    @Autowired
    public ShowService(ShowRepository showRepository, AuditoriumRepository auditoriumRepository,
                       MovieRepository movieRepository, TheatreRepository theatreRepository,
                       ShowSeatRepository showSeatRepository) {
        this.showRepository = showRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Show createShow(Long audiId, Long movieId,
                           Date startTime, Date endTime,
                           Language language, Map<SeatType, Integer> seatPricing)
            throws Exception {
//        check for the validity of the id's provided
        Optional<Auditorium> auditoriumOptional = auditoriumRepository.findById(audiId);
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if(!auditoriumOptional.isPresent() || !movieOptional.isPresent()){
            throw new Exception("not found");
        }
//        get the table objects of the respective id.
        Auditorium auditoriumDb = auditoriumOptional.get();
        Movie movieDb = movieOptional.get();
//        create a show.
        Show show = new Show();
        show.setEndTime(endTime);
        show.setStartTime(startTime);
        show.setLanguage(language);

//        map to other tables
        show.setAuditorium(auditoriumDb);
        show.setMovie(movieDb);

//        save in repository
        Show savedShow = showRepository.save(show);

        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(Seat seat:auditoriumDb.getSeats()){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setShow(savedShow);
            showSeat.setSeat(seat);
            showSeat.setShowSeatState(ShowSeatState.AVAILABLE);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        savedShow.setShowSeats(savedShowSeats);

//        add show object in the other tables!. and save them
//        Theatre theatre = auditoriumDb.getTheatre();
//        theatre.getShows().add(savedShow);
//        theatreRepository.save(theatre);

        return showRepository.save(savedShow);
    }
}
