package com.airline.service.controller;

import com.airline.service.base.BaseResponse;
import com.airline.service.dto.FlightRequestBody;
import com.airline.service.dto.TicketBookRequestBody;
import com.airline.service.dto.TicketRequestBody;
import com.airline.service.model.Flight;
import com.airline.service.model.Ticket;
import com.airline.service.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

//    @GetMapping("")
//    public BaseResponse getInfoById(@RequestParam Long flightId){
//        Flight flight = flightService.getById(flightId);
//        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully retrieved")
//                .setData(flight);
//    }

    @PostMapping("/create")
    public BaseResponse createNewTicket(@RequestBody TicketRequestBody requestBody){
        Ticket ticket = ticketService.createTicket(requestBody);
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully Created new Ticket")
                .setData(ticket);
    }

    @PostMapping("/book")
    public BaseResponse bookExistingAvailableTicket(@RequestBody TicketBookRequestBody requestBody) throws ParseException {
        requestBody.setOrderQuantity(requestBody.getTicketIds().size());
        List<Ticket> ticketList = ticketService.bookTicket(requestBody);
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully Created new Flight")
                .setData(ticketList);
    }



//    @GetMapping("/all")
//    public BaseResponse getAll(){
//        List<Flight> flightList = flightService.getAll();
//        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully retrieved")
//                .setData(flightList);
//    }
}
