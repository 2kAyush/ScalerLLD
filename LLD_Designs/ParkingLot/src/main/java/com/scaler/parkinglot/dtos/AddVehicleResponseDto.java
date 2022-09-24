package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.Vehicle;

public class AddVehicleResponseDto {
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
