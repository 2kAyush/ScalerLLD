package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.Actor;
import com.scaler.bookmyshow.repositories.ActorRepository;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    private ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor addActor(String name) {
        Actor actor = new Actor();
        actor.setName(name);

        return actorRepository.save(actor);
    }

}
