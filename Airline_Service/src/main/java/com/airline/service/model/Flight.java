package com.airline.service.model;

import com.airline.service.enums.FlightCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import static org.apache.tomcat.util.http.FastHttpDateFormat.getCurrentDate;

@Entity
@Table(name = "Flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Flight_Number")
    private String flightNumber;

    @Enumerated(EnumType.STRING)
    private FlightCategory category;

    @ManyToOne
    @JoinColumn(name = "Route_Id")
    private Route route;

    @Column(name = "Departure_Time")
    private Date departureTime;

    @Column(name = "Arrival_Time")
    private Date arrivalTime;

    @Column(name = "Total_Sales")
    private BigDecimal totalSales= BigDecimal.valueOf(0);

}
