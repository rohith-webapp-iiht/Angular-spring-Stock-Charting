package com.prabhu.companyservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabhu.companyservice.entities.Company;
import com.prabhu.companyservice.repos.customRepos.CompanyRepoCustom;

/**
 * @project company-service
 * @author Prabhu Madipalli
 */

public interface CompanyRepo extends JpaRepository<Company, Integer>, CompanyRepoCustom {

    List<Company> findCompaniesByNameContaining(String partName);

    Company findCompanyByName(String name);


}
