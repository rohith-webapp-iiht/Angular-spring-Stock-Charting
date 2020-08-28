package com.prabhu.companyservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */

@Entity(name = "stockcodes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockCode {

    @Column(name = "stockcode_id")
    @Id
    @GeneratedValue
    @JsonIgnore()
    private int id;

    @Column(name = "code", nullable = false)
    private String code;

    @JoinColumn(name = "stock_exchange_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private StockExchange stockExchange;

    @JoinColumn(nullable = false, name = "comapny_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToOne(mappedBy = "ipo", targetEntity = Ipo.class, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "ipo_id", nullable = true)
    private Ipo ipo;
}
