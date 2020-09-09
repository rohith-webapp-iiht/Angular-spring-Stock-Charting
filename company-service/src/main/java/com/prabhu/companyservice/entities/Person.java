package com.prabhu.companyservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */

@Entity(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    @JsonIgnore()
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private int id;

    @Column(name = "person_name")
    private String name;

    @JsonIgnore()
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company memberOf;

    public Person(String name){
        this.name = name;
    }
}
