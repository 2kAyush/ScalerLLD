package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.AddVehicleRequestDto;
import com.scaler.parkinglot.dtos.AddVehicleResponseDto;
import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.services.VehicleService;

public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public AddVehicleResponseDto addVehicle(AddVehicleRequestDto requestDto) {
        Vehicle vehicle = vehicleService.addVehicle(requestDto.getNumber(), requestDto.getVehicleType());
        AddVehicleResponseDto responseDto = new AddVehicleResponseDto();
        responseDto.setVehicle(vehicle);
        return responseDto;
    }

}
