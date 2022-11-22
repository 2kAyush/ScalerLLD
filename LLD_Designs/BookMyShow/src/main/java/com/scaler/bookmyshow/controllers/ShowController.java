package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.models.Language;
import com.scaler.bookmyshow.models.SeatType;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.services.ShowService;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Map;

@Controller
public class ShowController {
    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    public Show createShow(Long audiId, Long movieId, Date startTime,
                           Date endTime, Language language, Map<SeatType, Integer> seatPricing) {
        Show show = null;
        try {
            show = showService.createShow(audiId, movieId, startTime, endTime, language, seatPricing);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return show;
    }
}
