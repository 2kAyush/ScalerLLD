package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.*;
import com.scaler.parkinglot.models.ParkingFloor;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.services.ParkingLotService;

import java.util.ArrayList;

public class ParkingLotController {
    private ParkingLotService parkingLotService;
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public CreateParkingLotResponseDto createParkingLot(CreateParkingLotRequestDto request) {

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress(request.getAddress());
        ArrayList<ParkingFloor> parkingFloors = new ArrayList<>();

        for(int i = 0;i < request.getNumberOfFloors();i++) {
            ParkingFloor floor = new ParkingFloor();
            floor.setFloorNumber(i);
            parkingFloors.add(floor);
        }
        parkingLot.setParkingFloors(parkingFloors);

        ParkingLot createdParkingLot = this.parkingLotService.createParkingLot(parkingLot);

        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
        response.setParkingLot(createdParkingLot);

        return response;
    }

    public UpdateParkingLotResponseDto updateParkingLot(UpdateParkingLotRequestDto request) {
        ParkingLot updatedParkingLot = this.parkingLotService.updateParkingLot(request.getParkingLotId(), request.getAddress());

        UpdateParkingLotResponseDto response = new UpdateParkingLotResponseDto();
        response.setParkingLot(updatedParkingLot);
        return response;
    }

    public AddSpotResponseDto addSpot(AddSpotRequestDto request) {
        ParkingLot updatedParkingLot = parkingLotService.addSpot(request.getParkingLotId(), request.getFloorNo(), request.getSpotType());

        AddSpotResponseDto response = new AddSpotResponseDto();
        response.setParkingLot(updatedParkingLot);
        return response;
    }
}
