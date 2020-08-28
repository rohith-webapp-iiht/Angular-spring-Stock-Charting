package com.prabhu.companyservice.repos;

import com.prabhu.companyservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project company-service
 * @authoer Prabhu Madipalli
 */

public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
