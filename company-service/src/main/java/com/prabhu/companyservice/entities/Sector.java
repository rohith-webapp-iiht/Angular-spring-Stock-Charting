package com.prabhu.companyservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */

@Entity(name = "sector")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sector {

    @Id
    @GeneratedValue
    @Column(name = "sector_id")
    private int id;

    @Column(name = "sector_name", nullable = false, unique = true)
    private String name;

    @Column(name = "sector_brief")
    private String brief;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
//    private List<Company> companies;
}
