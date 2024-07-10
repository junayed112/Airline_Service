package com.airline.service.controller;

import com.airline.service.base.BaseResponse;
import com.airline.service.dto.FlightRequestBody;
import com.airline.service.model.Flight;
import com.airline.service.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("")
    public BaseResponse getInfoById(@RequestParam Long flightId){
        Flight flight = flightService.getById(flightId);
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully retrieved")
                .setData(flight);
    }

    @PostMapping("/create")
    public BaseResponse createNewFlight(@RequestBody FlightRequestBody requestBody){
        Flight flight = flightService.createFlight(requestBody);
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully Created new Flight")
                .setData(flight);
    }

    @GetMapping("/all")
    public BaseResponse getAll(){
        List<Flight> flightList = flightService.getAll();
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully retrieved")
                .setData(flightList);
    }
}
