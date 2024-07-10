package com.airline.service.repository;

import com.airline.service.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;

public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query("SELECT COALESCE(SUM(f.totalOrderAmount), 0) FROM Food f WHERE f.purchaseDate BETWEEN :startDate AND :endDate")
    BigDecimal getTotalFoodSalesForDate(Date startDate, Date endDate);
}
