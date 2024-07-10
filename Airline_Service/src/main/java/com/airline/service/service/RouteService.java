package com.airline.service.service;

import com.airline.service.dto.RouteRequestBody;
import com.airline.service.model.Location;
import com.airline.service.model.Route;
import com.airline.service.repository.LocationRepository;
import com.airline.service.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private LocationRepository locationRepository;

    public Route createRoute(RouteRequestBody requestBody){
        Location source = locationRepository.findById(requestBody.getSourceId()).get();
        Location destination = locationRepository.findById(requestBody.getDestinationId()).get();

        Route route = new Route();
        route.setSource(source);
        route.setDestination(destination);
        return routeRepository.save(route);

    }

    public void updateTotalSales(Long id, BigDecimal amount){
        Route route = routeRepository.findById(id).get();
        BigDecimal totalAmount = route.getTotalSales().add(amount);
        route.setTotalSales(totalAmount);
        routeRepository.save(route);
    }

    public List<Route> findAllRoutes(){
        return routeRepository.findAll();
    }

    public Route getById(Long id){
        Route route = routeRepository.findById(id).get();
        if(route==null){
            throw new RuntimeException("Route Not Found");
        }
        return route;
    }
}
