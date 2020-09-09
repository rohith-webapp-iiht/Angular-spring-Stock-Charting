package com.prabhu.companyservice.dto.responses;

import java.util.List;

import com.prabhu.companyservice.entities.Address;
import com.prabhu.companyservice.entities.CompanyDetails;
import com.prabhu.companyservice.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyResponse {

    private int id;

    private String name;

    private long turnover;

    private Person ceo;

    private List<Person> bod;

    /**
     * Id and name of the StockExchange is enough here
     */
    private List<StockExchangeResponse> listedIn;
    
    private List<StockCodeRespose> stockCodes;

    private SectorResponse sector;

    private List<IpoResponse> ipos;

    private Address address;

    private CompanyDetails furtherDetails;
}
