package com.airline.service.dto;

import com.airline.service.enums.FlightCategory;
import com.airline.service.model.Route;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRequestBody {

    private Integer flightCategoryCode;

    private Long routeId;

    private Date departureTime;

    private Date arrivalTime;

}

