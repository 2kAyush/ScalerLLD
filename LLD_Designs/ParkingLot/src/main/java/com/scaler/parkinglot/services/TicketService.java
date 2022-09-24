package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.strategies.spotassignmentstrategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(TicketRepository ticketRepository, SpotAssignmentStrategy spotAssignmentStrategy, ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(Long parkingLotId, Vehicle vehicle, SpotType spotType, EntryGate entryGate) {
        ParkingLot parkingLot = this.parkingLotRepository.getParkingLot(parkingLotId);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLot, spotType, entryGate);
        if(parkingSpot == null) return null;

        Ticket ticket = new Ticket();
        ticket.setEntryGate(entryGate);
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);
        ticket.setParkingLot(parkingLot);
        ticket.setGeneratedBy(entryGate.getOperator());
        ticket.setEntryTime(new Date());
        return ticketRepository.save(ticket);
    }
}
