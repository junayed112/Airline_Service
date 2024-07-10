package com.airline.service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequestBody {

    private String name;

    private BigDecimal unitPrice;

    private Long quantity;

    private LocalDateTime purchaseDate;
}
