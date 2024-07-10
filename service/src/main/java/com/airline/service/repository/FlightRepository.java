package com.airline.service.repository;

import com.airline.service.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByFlightNumber(String flightNumber);

    @Query("SELECT f.flightNumber, SUM(f.totalSales) as totalSales " +
            "FROM Flight f " +
            "GROUP BY f.flightNumber " +
            "ORDER BY totalSales DESC")
    List<Object[]> findTopSellingFlight();
}
