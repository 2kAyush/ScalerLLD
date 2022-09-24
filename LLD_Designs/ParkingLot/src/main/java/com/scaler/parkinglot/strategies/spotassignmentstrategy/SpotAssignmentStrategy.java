package com.scaler.parkinglot.strategies.spotassignmentstrategy;

import com.scaler.parkinglot.models.*;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(ParkingLot parkingLot,
                                  SpotType spotType,
                                  EntryGate entryGate
                                );

}
