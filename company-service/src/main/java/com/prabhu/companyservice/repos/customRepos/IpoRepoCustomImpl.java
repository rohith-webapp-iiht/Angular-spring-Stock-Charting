package com.prabhu.companyservice.repos.customRepos;

import java.util.List;

import com.prabhu.companyservice.entities.Company;
import com.prabhu.companyservice.entities.Ipo;

/**
 * This belongs to company-service
 *
 * @author Prabhu Madipalli
 */


public class IpoRepoCustomImpl implements IpoRepoCustom{
    @Override
    public List<Ipo> findIposByCompanySafely(Company company) {
        return null;
    }

    @Override
    public List<Ipo> findIposByCompanySafely(int companyId) {
        return null;
    }
}
