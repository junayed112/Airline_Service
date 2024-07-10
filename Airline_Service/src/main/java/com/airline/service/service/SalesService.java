package com.airline.service.service;

import com.airline.service.dto.FlightSalesDto;
import com.airline.service.dto.RouteSalesDTO;
import com.airline.service.dto.TicketAndFoodSalesResponse;
import com.airline.service.model.Flight;
import com.airline.service.model.Route;
import com.airline.service.repository.FlightRepository;
import com.airline.service.repository.FoodRepository;
import com.airline.service.repository.RouteRepository;
import com.airline.service.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private RouteRepository routeRepository;

    public TicketAndFoodSalesResponse getTotalSalesForToday() {
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startOfDay = calendar.getTime();

        // Set the end of the day (one millisecond before midnight of the next day)
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date endOfDay = calendar.getTime();
        BigDecimal totalTicketSales = ticketRepository.getTotalTicketSalesForDate(startOfDay, endOfDay);
        BigDecimal totalFoodSales = foodRepository.getTotalFoodSalesForDate(startOfDay, endOfDay);

        BigDecimal totalAmount = totalTicketSales.add(totalFoodSales);
        TicketAndFoodSalesResponse response = new TicketAndFoodSalesResponse(totalTicketSales, totalFoodSales, totalAmount);
        return response;
    }

    public Date getMaxSaleDayInRange(Date startDate, Date endDate) {
        List<Object[]> result = ticketRepository.getMaxSaleDayInRange(startDate, endDate);

        if (!result.isEmpty()) {
            return (Date) result.get(0)[0];
        }

        return null;
    }

    public List<FlightSalesDto> getTopSellingFlights() {
        List<Object[]> result = flightRepository.findTopSellingFlight();

        return result.stream()
                .map(record -> new FlightSalesDto((Flight) record[0], (BigDecimal) record[1]))
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<Route> getTopSellingRoutes() {
        List<Route> result = routeRepository.findTopByTotalSales();

        return result.subList(0,3);

//        return result.stream()
//                .map(record -> new RouteSalesDTO((Route) record[0], (BigDecimal) record[1]))
//                .limit(3)
//                .collect(Collectors.toList());
    }
}
