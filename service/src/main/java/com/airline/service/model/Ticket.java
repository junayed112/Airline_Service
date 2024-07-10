package com.airline.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Flight_Id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    private Customer customer;

    @Column(name = "Seat_Number")
    private String seatNumber;

    @Column(name = "Unit_Price")
    private BigDecimal unitPrice;

    @Column(name = "Is_Booked")
    private Boolean isBooked = false;

    @Column(name = "Purchase_Date")
    private Date purchaseDate;
}
