package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap = new HashMap<>();
    private long lastVehicleId = 0;

    public Vehicle add(Vehicle vehicle) {
        vehicleMap.put(lastVehicleId, vehicle);
        lastVehicleId++;
        return vehicle;
    }

    public Vehicle update(Vehicle vehicle) {
        vehicleMap.put(vehicle.getId(), vehicle);
        return vehicle;
    }
}
