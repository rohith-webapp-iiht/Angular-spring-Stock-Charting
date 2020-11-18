package com.prabhu.companyservice.service.impl;
import com.prabhu.companyservice.repos.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prabhu.companyservice.dto.responses.CompanyResponse;
import com.prabhu.companyservice.service.CompanyService;

@Service
//Change Qualifier and Service name
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepo repo;

	@Override
	public CompanyResponse CompanyById(int id) {
		return null;
	}
}
