package com.airline.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketBookRequestBody {
    private List<Long> ticketIds;
    private String flightNumber;
    private Long customerId;
    private Integer orderQuantity;
}
