package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.ParkingLotRepository;

import java.util.List;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    private int lastSpotNumber = 0;
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }
    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return this.parkingLotRepository.save(parkingLot);
    }

    public ParkingLot updateParkingLot(Long parkingLotId, String address) {
        ParkingLot parkingLot = this.parkingLotRepository.getParkingLot(parkingLotId);
        parkingLot.setAddress(address);
        return this.parkingLotRepository.update(parkingLot);
    }

    public ParkingLot addSpot(Long parkingLotId, int floorNo, SpotType spotType) {
        ParkingLot parkingLot = this.parkingLotRepository.getParkingLot(parkingLotId);
        ParkingFloor floor = null;
        for(ParkingFloor parkingFloor:parkingLot.getParkingFloors()){
            if(parkingFloor.getFloorNumber() == floorNo){
                floor = parkingFloor;
            }
        }
        if(floor == null) return null;
        ParkingSpot spot = new ParkingSpot();
        spot.setSpotNumber(lastSpotNumber);
        spot.setSpotType(spotType);
        spot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        spot.setParkingFloor(floor);
        List<ParkingSpot> spotList = floor.getParkingSpots();
        spotList.add(spot);
        floor.setParkingSpots(spotList);
        lastSpotNumber++;
        return this.parkingLotRepository.update(parkingLot);
    }
}
