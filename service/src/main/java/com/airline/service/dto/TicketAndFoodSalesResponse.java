package com.airline.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketAndFoodSalesResponse {
    private BigDecimal TicketSalesAmount;
    private BigDecimal FoodSalesAmount;
    private BigDecimal totalAmount;

}
