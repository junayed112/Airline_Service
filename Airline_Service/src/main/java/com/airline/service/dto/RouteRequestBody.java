package com.airline.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteRequestBody {

    private Long sourceId;

    private Long destinationId;
}
