package com.airline.service.service;

import com.airline.service.dto.TicketBookRequestBody;
import com.airline.service.dto.TicketRequestBody;
import com.airline.service.model.Customer;
import com.airline.service.model.Flight;
import com.airline.service.model.Ticket;
import com.airline.service.repository.CustomerRepository;
import com.airline.service.repository.TicketRepository;
import com.airline.service.utils.SystemDateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightService flightService;

    public Ticket createTicket(TicketRequestBody requestBody){
        Flight existingFlight = flightService.getById(requestBody.getFlightId());
        Ticket ticket = new Ticket();
        ticket.setFlight(existingFlight);
        ticket.setUnitPrice(requestBody.getUnitPrice());
        ticket.setSeatNumber(requestBody.getSeatNumber());

        return ticketRepository.save(ticket);
    }
    public List<Ticket> bookTicket(TicketBookRequestBody requestBody) throws ParseException {
        List<Ticket> tickets = ticketRepository.findAllById(requestBody.getTicketIds());
        tickets.removeIf(ticket -> ticket.getIsBooked());
        Customer customer = customerRepository.findById(requestBody.getCustomerId()).get();
        if(customer==null){
            throw new RuntimeException("Customer not found");
        }
        BigDecimal ticketPrice = tickets.get(0).getUnitPrice();
        if(tickets.size() == requestBody.getOrderQuantity()) {
            flightService.updateTotalSales(requestBody.getFlightNumber(), ticketPrice, requestBody.getOrderQuantity());
            for (Ticket ticket : tickets) {
                ticket.setCustomer(customer);
                ticket.setIsBooked(true);
                ticket.setPurchaseDate(SystemDateFormatter.setTicketPurchaseDate());
                ticketRepository.save(ticket);
            }
        }
        else{
            throw new RuntimeException("Tickets already booked");
        }
        return tickets;
    }

}
