package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {
    @ManyToOne
    private User bookedBy;
    @ManyToOne
    private Show show;
//    @OneToMany if no cancellation allowed
    @ManyToMany // cancellation is allowed that's why
    List<ShowSeat> showSeats;
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    private Date timeOfBooking;

}
