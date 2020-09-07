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


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ipo")

@NamedQuery(
        name = "find_ipos_by_company",
        query = "SELECT i, c FROM ipo i JOIN a.company c"
)
@NamedEntityGraph(
        name = "only company basic details"

)
public class Ipo {

    @Id
    @GeneratedValue
    @Column(name = "ipo_id")
    private int id;

    @Column(name = "stock_code")
    private String code;

    @OneToOne(optional = false, fetch = FetchType.LAZY, mappedBy = "ipo")
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

    @Column(name= "price_per_share", nullable=false)
    private long pricePerShare;

    @Column(name = "open_date")
    private Date openDate;
}
