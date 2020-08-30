package com.prabhu.companyservice.repos;

import com.prabhu.companyservice.entities.Company;
import com.prabhu.companyservice.entities.Ipo;
import com.prabhu.companyservice.entities.StockCode;
import com.prabhu.companyservice.entities.StockExchange;
import com.prabhu.companyservice.repos.customRepos.IpoRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * This belongs to company-service
 *
 * @author Prabhu Madipalli
 */
//Beware because all Ipos are even fetch the Company and the stock codes inside them.
public interface IpoRepo extends JpaRepository<Ipo, Integer>, IpoRepoCustom {

    Ipo findById(int id);

    Ipo findIpoByCode(String code);

    List<Ipo> findIposByCodeContaining(String partCode);

    Ipo findIpoByStockCode(StockCode stockCode);

    List<Ipo> findIposByCompany(Company Company);

    List<Ipo> findIposByStockExchange(StockExchange stockExchange);

    List<Ipo> findIposByOpenDateBefore(Date date);

    List<Ipo> findIposByOpenDateBeforeAndOpenDateAfter(Date beforeDate, Date afterDate);
}
