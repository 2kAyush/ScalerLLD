package com.scaler.parkinglot.dtos;

//DTO: Data Transfer Object

public class CreateParkingLotRequestDto {
    String address;
    int numberOfFloors;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    //    int numberOfEntry;
//    int numberOfExit;
//    String name;
}
