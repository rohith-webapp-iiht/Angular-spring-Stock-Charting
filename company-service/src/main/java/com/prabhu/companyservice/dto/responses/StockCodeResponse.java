package com.prabhu.companyservice.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prabhu.companyservice.entities.Company;
import com.prabhu.companyservice.entities.Ipo;
import com.prabhu.companyservice.entities.StockExchange;
import lombok.Data;

import javax.persistence.*;

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
