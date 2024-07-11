package com.airline.service.repository;

import com.airline.service.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT COALESCE(SUM(t.unitPrice), 0) FROM Ticket t WHERE t.purchaseDate BETWEEN :startDate AND :endDate AND t.isBooked = true")
    BigDecimal getTotalTicketSalesForDate(Date startDate, Date endDate);

    @Query("SELECT FUNCTION('DATE', t.purchaseDate) AS purchaseDate, SUM(t.unitPrice) AS totalSales " +
            "FROM Ticket t " +
            "WHERE FUNCTION('DATE', t.purchaseDate) BETWEEN :startDate AND :endDate AND t.isBooked = true " +
            "GROUP BY FUNCTION('DATE', t.purchaseDate) " +
            "ORDER BY totalSales DESC")
    List<Object[]> getMaxSaleDayInRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
