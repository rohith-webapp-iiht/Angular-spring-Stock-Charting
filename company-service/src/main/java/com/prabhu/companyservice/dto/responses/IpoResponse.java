package com.prabhu.companyservice.dto.responses;

import java.util.Date;

import com.prabhu.companyservice.entities.Company;
import com.prabhu.companyservice.entities.StockExchange;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */


public class IpoResponse {

    private int id;

    private StockCodeResponse stockCode;

    private Company company;

    private StockExchange stockExchange;

    private long numberOfShares;

    private Date openDate;
}
