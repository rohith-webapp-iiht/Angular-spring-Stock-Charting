package com.prabhu.companyservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor

import javax.persistence.*;
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

    @JsonIgnore()
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
    private List<Person> bod;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<StockCode> stockCodes;

    @ManyToOne(fetch = FetchType.EAGER, mapped)
    private Sector sector;

    @Embedded
    @JsonIgnore()
    private CompanyDetails furtherDetails;
}
