package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Ticket;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<Long, Ticket> tickets = new HashMap<>();
    private long ID = 0;
    public Ticket save(Ticket ticket) {
        ID++;
        ticket.setId(ID);
        tickets.put(ID, ticket);
        return ticket;
    }


    public Ticket getById(Long id) {
        return tickets.get(id);
    }
}
