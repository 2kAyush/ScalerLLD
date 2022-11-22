package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.CityNotFoundException;
import com.scaler.bookmyshow.models.City;
import com.scaler.bookmyshow.models.Theatre;
import com.scaler.bookmyshow.repositories.CityRepository;
import com.scaler.bookmyshow.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository, CityRepository cityRepository) {
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
    }

    public Theatre createTheatre(String name, String address, Long cityId) throws CityNotFoundException {
        Optional<City> cityOptional = cityRepository.findById(cityId);
        if(!cityOptional.isPresent()){
            throw new CityNotFoundException("City not found with this Id");
        }

        Theatre theatre = new Theatre();
        theatre.setAddress(address);
        theatre.setName(name);
        Theatre savedTheatre = this.theatreRepository.save(theatre);

        City dbCity = cityOptional.get();

        dbCity.getTheatres().add(savedTheatre);
        this.cityRepository.save(dbCity);

        return savedTheatre;
    }

}
