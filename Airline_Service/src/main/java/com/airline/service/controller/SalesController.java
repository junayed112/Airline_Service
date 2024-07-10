package com.airline.service.controller;

import com.airline.service.base.BaseResponse;
import com.airline.service.dto.FlightSalesDto;
import com.airline.service.dto.RouteSalesDTO;
import com.airline.service.dto.TicketAndFoodSalesResponse;
import com.airline.service.model.Route;
import com.airline.service.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/total-sales-today")
    public BaseResponse getTotalSalesForToday() {
        TicketAndFoodSalesResponse response = salesService.getTotalSalesForToday();
        return new BaseResponse<>(200, "Successfully rettrieved", response);
    }

    @GetMapping("/max-sale-day")
    public BaseResponse getMaxSaleDayInRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Date response = salesService.getMaxSaleDayInRange(startDate, endDate);
        return new BaseResponse<>(200, "Successfully retrieved", response);
    }

    @GetMapping("/top-selling-flights")
    public BaseResponse getTopSellingFlights() {
        List<FlightSalesDto> response = salesService.getTopSellingFlights();
        return new BaseResponse<>(200, "Successfully retrieved", response);
    }

    @GetMapping("/top-selling-routes")
    public BaseResponse getTopSellingRoutes() {
        List<Route> response = salesService.getTopSellingRoutes();
        return new BaseResponse<>(200, "Successfully retrieved", response);
    }
}
