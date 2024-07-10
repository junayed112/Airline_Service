package com.airline.service.service;

import com.airline.service.dto.FlightRequestBody;
import com.airline.service.enums.FlightCategory;
import com.airline.service.model.Flight;
import com.airline.service.model.Route;
import com.airline.service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private RouteService routeService;

    public Flight createFlight(FlightRequestBody flightRequestBody){
        Route existingRoute = routeService.getById(flightRequestBody.getRouteId());
        FlightCategory flightCategory = FlightCategory.getFlightCategory(flightRequestBody.getFlightCategoryCode());

        Flight flight = new Flight();
        flight.setFlightNumber(generateFlightNumber());
        flight.setCategory(flightCategory);
        flight.setRoute(existingRoute);
        flight.setArrivalTime(flightRequestBody.getArrivalTime());
        flight.setDepartureTime(flightRequestBody.getDepartureTime());

        return flightRepository.save(flight);

    }

    public void updateTotalSales(String flightNumber, BigDecimal ticketPrice, Integer multiplier){
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        ticketPrice = ticketPrice.multiply(BigDecimal.valueOf(multiplier));
        BigDecimal totalAmount = flight.getTotalSales().add(ticketPrice);
        flight.setTotalSales(totalAmount);
        flightRepository.save(flight);
        routeService.updateTotalSales(flight.getRoute().getId(), ticketPrice);
    }

    public Flight getById(Long id){
        Flight flight = flightRepository.findById(id).get();
        if(flight==null){
            throw new RuntimeException("Flight Id Not Found");
        }
        return flight;
    }

    public List<Flight> getAll(){
        return flightRepository.findAll();
    }

    public String generateFlightNumber(){
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replaceAll("-", "");
        return uuidString.substring(0,8);
    }
}
