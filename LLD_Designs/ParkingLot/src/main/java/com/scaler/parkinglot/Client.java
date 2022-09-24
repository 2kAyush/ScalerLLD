package com.scaler.parkinglot;

import com.scaler.parkinglot.controllers.ParkingLotController;
import com.scaler.parkinglot.controllers.TicketController;
import com.scaler.parkinglot.controllers.VehicleController;
import com.scaler.parkinglot.dtos.*;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.repositories.VehicleRepository;
import com.scaler.parkinglot.services.ParkingLotService;
import com.scaler.parkinglot.services.TicketService;
import com.scaler.parkinglot.services.VehicleService;
import com.scaler.parkinglot.strategies.spotassignmentstrategy.RandomSpotAssignmentStrategy;
import com.scaler.parkinglot.strategies.spotassignmentstrategy.SpotAssignmentStrategy;

public class Client {
    public static void main(String[] args) {

//        Parking Lot's
        ObjectRegistry.put("parkingLotRepository", new ParkingLotRepository());
        ObjectRegistry.put("parkingLotService", new ParkingLotService(
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository"))
        );
        ObjectRegistry.put("parkingLotController", new ParkingLotController(
                (ParkingLotService) ObjectRegistry.get("parkingLotService"))
        );

//        Parking Ticket's
        ObjectRegistry.put("ticketRepository", new TicketRepository());
        ObjectRegistry.put("randomSpotAssignmentStrategy", new RandomSpotAssignmentStrategy());
        ObjectRegistry.put("ticketService", new TicketService(
                (TicketRepository) ObjectRegistry.get("ticketRepository"),
                (SpotAssignmentStrategy) ObjectRegistry.get("randomSpotAssignmentStrategy"),
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("ticketController", new TicketController(
                (TicketService) ObjectRegistry.get("ticketService")
        ));
        ObjectRegistry.put("ticketRepository", new TicketRepository());

//        Vehicles
        ObjectRegistry.put("vehicleRepository", new VehicleRepository());
        ObjectRegistry.put("vehicleService", new VehicleService(
                (VehicleRepository) ObjectRegistry.get("vehicleRepository")
        ));
        ObjectRegistry.put("vehicleController", new VehicleController(
                (VehicleService) ObjectRegistry.get("vehicleService")
        ));

//        All Controllers
        ParkingLotController parkingLotController = (ParkingLotController) ObjectRegistry.get("parkingLotController");
        TicketController ticketController = (TicketController) ObjectRegistry.get("ticketController");
        VehicleController vehicleController = (VehicleController) ObjectRegistry.get("vehicleController");

// Create Parking lot
        CreateParkingLotRequestDto request = new CreateParkingLotRequestDto();
        request.setAddress("India");
        request.setNumberOfFloors(4);

        CreateParkingLotResponseDto response = parkingLotController.createParkingLot(request);
        System.out.println(response.getParkingLot());

// add parking spot here
        AddSpotRequestDto spotRequestDto = new AddSpotRequestDto();
        spotRequestDto.setParkingLotId(1L);
        spotRequestDto.setSpotType(SpotType.ELECTRIC);
        spotRequestDto.setFloorNo(0);

        AddSpotResponseDto spotResponseDto = parkingLotController.addSpot(spotRequestDto);
        ParkingLot parkingLot = spotResponseDto.getParkingLot();
        System.out.println();

// Update Address
        UpdateParkingLotRequestDto updateRequest = new UpdateParkingLotRequestDto();
        updateRequest.setAddress("Delhi Airport");
        updateRequest.setParkingLotId((1L));

        UpdateParkingLotResponseDto responseDto = parkingLotController.updateParkingLot(updateRequest);
        System.out.println(responseDto.getParkingLot());

// add a vehicle
        AddVehicleRequestDto addVehicleRequest = new AddVehicleRequestDto();
        addVehicleRequest.setNumber("2467");
        addVehicleRequest.setVehicleType(VehicleType.ELECTRIC);

        AddVehicleResponseDto addVehicleResponse = vehicleController.addVehicle(addVehicleRequest);
        System.out.println(addVehicleResponse);

//Generate ticket
        GenerateTicketRequestDto ticketRequest = new GenerateTicketRequestDto();

        ticketRequest.setEntryGate(new EntryGate(new DisplayBoard()));
        ticketRequest.setParkingLotId(1L);
        ticketRequest.setVehicle(new Vehicle());
        ticketRequest.setSpotType(SpotType.MEDIUM);
        GenerateTicketResponseDto ticketResponseDto = ticketController.generateTicket(ticketRequest);
        Ticket ticket = ticketResponseDto.getTicket();
        System.out.println(ticket);

    }
}
