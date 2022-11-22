package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.ShowRepository;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.bookmyshow.repositories.TicketRepository;
import com.scaler.bookmyshow.repositories.UserRepository;
import com.zaxxer.hikari.util.IsolationLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private TicketRepository ticketRepository;
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;
    private ShowRepository showRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ShowSeatRepository showSeatRepository,
                         UserRepository userRepository, ShowRepository showRepository) {
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    /** private List<ShowSeat> getShowSeatDb(List<Long> showSeatIds) {
    *    List<ShowSeat> showSeats = new ArrayList<>();
    *    for(int i = 0;i < showSeatIds.size();++i) {
    *        Optional<ShowSeat> showSeatOptional = showSeatRepository.findById(showSeatIds.get(i));
    *        showSeats.add(showSeatOptional.get());
    *    }
    *    return showSeats;
    } */

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId, List<Long> showSeatIds, Long userId) throws ShowSeatNotAvailableException{
        List<ShowSeat> showSeats = showSeatRepository.findByIdIn(showSeatIds);
//        List<ShowSeat> showSeats = getShowSeatDb(showSeatIds);
        for(ShowSeat showSeat: showSeats) {
            if(showSeat.getShowSeatState() != ShowSeatState.AVAILABLE) {
                throw new ShowSeatNotAvailableException("seats are not available as of now");
            }
        }
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new ShowSeatNotAvailableException("Wrong UserId");
        }
        User user = userOptional.get();

        Optional<Show> showOptional = showRepository.findById(showId);
        if(!showOptional.isPresent()){
            throw new ShowSeatNotAvailableException("Wrong ShowId");
        }
        Show show = showOptional.get();

        for(ShowSeat showSeat: showSeats) {
            showSeat.setShowSeatState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }

        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setBookedBy(user);
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        ticket.setTimeOfBooking(new Date());


        return ticketRepository.save(ticket);
    }
}
