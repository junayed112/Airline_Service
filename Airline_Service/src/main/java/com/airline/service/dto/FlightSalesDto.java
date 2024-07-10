package com.airline.service.dto;

import com.airline.service.model.Flight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSalesDto {

    private Flight flight;
    private BigDecimal totalSales;
}
