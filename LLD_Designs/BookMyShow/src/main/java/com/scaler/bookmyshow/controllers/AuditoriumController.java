package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.exceptions.AuditoriumNotFoundException;
import com.scaler.bookmyshow.exceptions.TheatreNotFoundException;
import com.scaler.bookmyshow.models.Auditorium;
import com.scaler.bookmyshow.models.AuditoriumFeature;
import com.scaler.bookmyshow.models.SeatType;
import com.scaler.bookmyshow.services.AuditoriumService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
//@AllArgsConstructor        // either create constructor or use this lombok annotation !.
public class AuditoriumController {
    private AuditoriumService auditoriumService;

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    public Auditorium createAudi(String name, int capacity, Long theatreId) {
        Auditorium auditorium = null;
        List<AuditoriumFeature> auditoriumFeatures = List.of(AuditoriumFeature.THREE_D, AuditoriumFeature.DOLBY);
        try {
            auditorium = auditoriumService.createAudi(name, capacity, auditoriumFeatures, theatreId);
        }
        catch (TheatreNotFoundException t){
            System.out.println("something went wrong");
            System.out.println(t);
        }
        return auditorium;
    }

    public void addSeats(Long auditoriumId, Map<SeatType, Integer> seatCount) {
        try {
            auditoriumService.addSeats(auditoriumId, seatCount);
        }
        catch (AuditoriumNotFoundException e) {
            System.out.println(e);
        }
    }

}
