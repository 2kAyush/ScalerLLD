package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.*;


public class GenerateTicketRequestDto {
    private Vehicle vehicle;
    private EntryGate entryGate;

    private SpotType spotType;

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    private Long parkingLotId;

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
