package com.airline.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Foods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Unit_Price")
    private BigDecimal unitPrice;

    @Column(name = "Quantity")
    private Long quantity;

    @Column(name = "Remaining_Quantity")
    private Long remainingQuantity;

    @Column(name = "Number_of_Orders")
    private Long numberOfOrders;

    @Column(name = "Total_Order_Amount")
    private BigDecimal totalOrderAmount = BigDecimal.ZERO;

    @Column(name = "Purchase_Date")
    private Date purchaseDate;
}
