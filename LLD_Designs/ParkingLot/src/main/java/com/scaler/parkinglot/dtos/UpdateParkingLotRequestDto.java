package com.scaler.parkinglot.dtos;

public class UpdateParkingLotRequestDto {
    private Long parkingLotId;

    private String address;
    private int numberOfFloors;
    public Long getParkingLotId() {
        return this.parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

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
}
