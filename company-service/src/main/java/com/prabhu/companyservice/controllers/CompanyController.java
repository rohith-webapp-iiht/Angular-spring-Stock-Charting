package com.prabhu.companyservice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prabhu.companyservice.dto.responses.CompanyResponse;
import com.prabhu.companyservice.service.CompanyService;

/**
 * @project company-service
 */


@RestController
@RequestMapping("/api/info")
public class CompanyController {

	@Autowired
	@Qualifier("complete")
	private CompanyService companyService;
	

	/**
     * This function return a response entity with the details mentioned in the below format/terms
     * id
     * name
     * turnover
     * ceo:{id:<id> name: CEO NAME}
     * bod: [{id:<id> name: board number name},{id:<id> name: board number name},{name: board number name},]
     * Sector { name: name_field, brief: briefing}
     * Ipo json objects -- No Ipo objects. No Ipo details
     * Stocks Json Objects: stockcode_id, code as string, StockExchange object containing it's id and name as string
     * Address -- Complete address object
     * furtherDetails -- Complete Object
     */
    @GetMapping("/comapny/{id}")
    public ResponseEntity<CompanyResponse> detailsById(@PathVariable("id") int id){
		
    	CompanyResponse company = this.companyService.CompanyById(id);
    	
    	
    	
    	return null;
    }
}
