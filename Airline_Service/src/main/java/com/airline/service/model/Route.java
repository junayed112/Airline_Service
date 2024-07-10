package com.airline.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Route")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "From_Location_Id", referencedColumnName = "id")
    private Location source;

    @ManyToOne
    @JoinColumn(name = "To_Location_Id", referencedColumnName = "id")
    private Location destination;

    @Column(name = "Total_Sales")
    private BigDecimal totalSales= BigDecimal.valueOf(0);

}
