package com.airline.service.controller;

import com.airline.service.base.BaseResponse;
import com.airline.service.dto.LocationRequestBody;
import com.airline.service.model.Location;
import com.airline.service.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/create")
    public BaseResponse createLocation(@RequestBody LocationRequestBody requestBody) {
        Location createdLocation = locationService.createLocation(requestBody);
        return new BaseResponse<>(200, "Successfully created", createdLocation);
    }
}
