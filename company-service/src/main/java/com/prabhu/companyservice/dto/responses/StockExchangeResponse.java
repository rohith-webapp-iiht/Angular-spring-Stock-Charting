package com.prabhu.companyservice.dto.responses;

import com.prabhu.companyservice.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockExchangeResponse {

    private int id;

    private String name;

    private String biref;

    private Address address;

    private String remarks;
}
