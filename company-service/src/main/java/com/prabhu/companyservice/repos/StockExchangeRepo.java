package com.prabhu.companyservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabhu.companyservice.entities.StockExchange;

/**
 * This belongs to company-service
 *
 * @author Prabhu Madipalli
 */

public interface StockExchangeRepo extends JpaRepository<StockExchange, Integer> {

    StockExchange findStockExchangeByName(String name);

    StockExchange findStockExchangesByNameContaining(String partName);
}
