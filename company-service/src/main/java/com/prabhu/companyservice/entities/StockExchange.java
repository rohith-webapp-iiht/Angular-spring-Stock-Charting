package com.prabhu.companyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "stock_exchange")
public class StockExchange {

    @Id
    @GeneratedValue
    @Column(name = "stock_exchange_id")
    private int id;

    @Column(name = "stock_exchange_name")
    private String name;

    @Column(name = "stock_exchange_brief")
    private String brief;

    @Embedded
    private Address address;

    @Column(name = "stock_exchange_remarks")
    private String remarks;
}
