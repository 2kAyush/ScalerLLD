package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.Ticket;

public class GenerateTicketResponseDto {
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
