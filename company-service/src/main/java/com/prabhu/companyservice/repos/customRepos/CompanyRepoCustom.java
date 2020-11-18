package com.prabhu.companyservice.repos.customRepos;

import com.prabhu.companyservice.entities.Company;

import java.util.List;
import java.util.Optional;

/**
 */

public interface CompanyRepoCustom {

    List<Company> findCompaniesByNameContainingBasic(String partName);

    Optional<Company> findByIdBasic(Integer integer);

    List<Company> findAllBasic();

    Optional<Object> findCompanyByNameBasic(String name);

    List<Company> findCompaniesByNameContainingComplete(String partName);

    Optional<Company> findByIdComplete(Integer id);

    List<Company> findAllComplete();

    Optional<Object> findCompanyByNameComplete(String name);

    List<Company> findCompaniesByNameContainingSingle(String partName);

    Optional<Company> findByIdSingle(Integer id);

    List<Company> findAllSingle();

    Optional<Object> findCompanyByNameSingle(String name);

}
