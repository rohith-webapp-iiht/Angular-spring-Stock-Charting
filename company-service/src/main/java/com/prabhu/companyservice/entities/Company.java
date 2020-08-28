package com.prabhu.companyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */
@Entity(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private int id;

    @Column(name = "company_name", nullable = false)
    private String name;

    @Column(name = "company_turnover", nullable = true)
    private long turnover;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ceo", nullable = false)
    private Person ceo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<Person> bod = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<StockCode> stockCodes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ipo")
    private List<Ipo> ipos;

    @Embedded
    private Address address;

    @Embedded
    private CompanyDetails furtherDetails;
//    @Column(name = "activation")
//    private Boolean active = true;
}
