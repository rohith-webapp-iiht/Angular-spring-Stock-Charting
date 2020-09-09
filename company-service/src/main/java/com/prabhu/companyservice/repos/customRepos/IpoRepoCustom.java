package com.prabhu.companyservice.repos.customRepos;

import java.util.List;

import com.prabhu.companyservice.entities.Company;
import com.prabhu.companyservice.entities.Ipo;

/**
 * This belongs to company-service
 *
 * @author Prabhu Madipalli
 */

public interface IpoRepoCustom {

    List<Ipo> findIposByCompanySafely(Company company);

    List<Ipo> findIposByCompanySafely(int companyId);


}
