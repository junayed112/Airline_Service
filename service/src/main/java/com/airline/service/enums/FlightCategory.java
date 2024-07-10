package com.airline.service.enums;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public enum FlightCategory {
    INTERNATIONAL(1, "International"),
    DOMESTIC(2, "Domestic");

    private final Integer code;
    private final String name;

    public static FlightCategory getFlightCategory(Integer code){
        for(FlightCategory category: FlightCategory.values()){
            if(category.code.equals(code) ){
                return category;
            }
        }
        return null;
    }
}
