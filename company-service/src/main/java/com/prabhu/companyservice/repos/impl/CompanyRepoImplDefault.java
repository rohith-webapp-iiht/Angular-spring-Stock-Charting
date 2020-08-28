package com.prabhu.companyservice.repos.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import com.prabhu.companyservice.entities.Company;


@Service
@Qualifier("Default")
public class CompanyRepoImplDefault extends SimpleJpaRepository<Company, Integer>{

	@Autowired
	public CompanyRepoImplDefault(Class<Company> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}
	
	

}
