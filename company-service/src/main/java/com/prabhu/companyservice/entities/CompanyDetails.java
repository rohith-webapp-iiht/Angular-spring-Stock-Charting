package com.prabhu.companyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CompanyDetails {


    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String description;

    private String services;

    private String products;

}
