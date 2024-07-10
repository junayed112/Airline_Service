package com.airline.service.dto;

import com.airline.service.model.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteSalesDTO {
    private Route route;
    private BigDecimal totalSales;

}
