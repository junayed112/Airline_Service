package com.airline.service.dto;

import com.airline.service.model.Customer;
import com.airline.service.model.Flight;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestBody {

    private Long flightId;

//    private Long customer;

    private String seatNumber;
    private BigDecimal unitPrice;

//    private LocalDateTime purchaseDate;
}
