package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    Map<Long, ParkingLot> parkingLots = new HashMap<>();
    private Long lastCount = 0L;

    public ParkingLot save(ParkingLot parkingLot) {
        lastCount += 1;
        parkingLot.setId(lastCount);
        parkingLots.put(lastCount, parkingLot);
        return parkingLot;
    }

    public ParkingLot update(ParkingLot parkingLot) {
        parkingLots.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }

    public ParkingLot getParkingLot(Long Id) {
        return parkingLots.get(Id);
    }

}
