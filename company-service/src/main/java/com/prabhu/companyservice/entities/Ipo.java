package com.prabhu.companyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */

@Entity(name = "ipo")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ipo {

    @Id
    @GeneratedValue
    @Column(name = "ipo_id")
    private int id;

    @OneToOne(optional = false, fetch = FetchType.EAGER, mappedBy = "ipo")
    @JoinColumn(name = "stockcode_id", nullable = false)
    private StockCode stockCode;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Company.class, optional = false)
    @JoinColumn(nullable = false, name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = StockExchange.class, optional = false)
    @JoinColumn(nullable = false, name = "stock_exchange_id")
    private StockExchange stockExchange;

    @Column(name = "number_of_shares", nullable = false)
    private long numberOfShares;

    @Column(name = "opendate")
    private Date openDate;
}
