package com.prabhu.companyservice.service;

import com.prabhu.companyservice.dto.responses.CompanyResponse;

public interface CompanyService {
	/**
	 * @param id
	 * @return Contains all company details and also stock code objects and stock exchange objects
	 */
	CompanyResponse CompanyById(int id);

}
