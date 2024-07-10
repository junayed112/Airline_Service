package com.airline.service.repository;

import com.airline.service.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("SELECT f.id, SUM(f.totalSales) as totalSales " +
            "FROM Route f " +
            "GROUP BY f.id " +
            "ORDER BY totalSales DESC")
    List<Object[]> findTopSellingRoutes();

    @Query("SELECT r FROM Route r ORDER BY r.totalSales DESC NULLS LAST")
    List<Route> findTopByTotalSales();
}
