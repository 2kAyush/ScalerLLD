package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.models.Actor;
import com.scaler.bookmyshow.services.ActorService;
import org.springframework.stereotype.Controller;

@Controller
public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    public Actor addActor(String name){
        return actorService.addActor(name);
    }
}
