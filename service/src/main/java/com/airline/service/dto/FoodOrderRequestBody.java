package com.airline.service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderRequestBody {

    private Long foodItemId;
    private Long quantity;
}
