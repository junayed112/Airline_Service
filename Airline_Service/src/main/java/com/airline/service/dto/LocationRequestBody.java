package com.airline.service.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequestBody {

    private String airportName;
    private String city;
    private String country;
}
