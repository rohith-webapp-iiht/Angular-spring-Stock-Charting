package com.prabhu.companyservice.dto.responses;

import com.prabhu.companyservice.entities.Company;
import com.prabhu.companyservice.entities.StockExchange;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */


public class StockCodeResponse {


    private int id;

    private String code;

    private StockExchange stockExchange;

    private Company company;
}
