package com.airline.service.controller;

import com.airline.service.base.BaseResponse;
import com.airline.service.dto.FlightRequestBody;
import com.airline.service.dto.RouteRequestBody;
import com.airline.service.model.Flight;
import com.airline.service.model.Route;
import com.airline.service.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("")
    public BaseResponse getInfoById(@RequestParam Long routeId){
        Route route = routeService.getById(routeId);
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully retrieved")
                .setData(route);
    }

    @PostMapping("/create")
    public BaseResponse createNewFlight(@RequestBody RouteRequestBody requestBody){
        Route route = routeService.createRoute(requestBody);
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully Created new Route")
                .setData(route);
    }

    @GetMapping("/all")
    public BaseResponse getAll(){
        List<Route> routeList = routeService.findAllRoutes();
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully retrieved")
                .setData(routeList);
    }
}
