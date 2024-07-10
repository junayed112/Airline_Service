package com.airline.service.service;

import com.airline.service.dto.LocationRequestBody;
import com.airline.service.model.Location;
import com.airline.service.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(LocationRequestBody requestBody){
        Location location = new Location();
        location.setAirportName(requestBody.getAirportName());
        location.setCity(requestBody.getCity());
        location.setCountry(requestBody.getCountry());
        return locationRepository.save(location);
    }
}
