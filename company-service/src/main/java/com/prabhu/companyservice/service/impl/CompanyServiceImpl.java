package com.prabhu.companyservice.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.prabhu.companyservice.dto.responses.CompanyResponse;
import com.prabhu.companyservice.service.CompanyService;

@Service
@Qualifier("Default")
//Change Qualifier and Service name
public class CompanyServiceImpl implements CompanyService {

	@Override
	public CompanyResponse CompanyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
