package com.prabhu.companyservice.repos;

import com.prabhu.companyservice.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This belongs to company-service
 *
 * @author Prabhu Madipalli
 */

public interface StockExchangeRepo extends JpaRepository<StockExchange, Integer> {

    StockExchange findStockExchangeByName(String name);

    StockExchange findStockExchangesByNameContaining(String partName);
}
