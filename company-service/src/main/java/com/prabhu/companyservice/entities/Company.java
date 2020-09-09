package com.prabhu.companyservice.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
