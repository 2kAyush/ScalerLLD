package com.scaler.parkinglot.strategies.spotassignmentstrategy;

import com.scaler.parkinglot.models.*;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, SpotType spotType, EntryGate entryGate) {
        for(ParkingFloor parkingFloor:parkingLot.getParkingFloors()) {
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()){
                if(parkingSpot.getSpotType() == spotType && parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)){
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
