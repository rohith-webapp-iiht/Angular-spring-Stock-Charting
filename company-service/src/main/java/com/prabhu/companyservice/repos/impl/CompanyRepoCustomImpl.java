package com.prabhu.companyservice.repos.impl;

import com.prabhu.companyservice.entities.Company;
import com.prabhu.companyservice.entities.StockCode;
import com.prabhu.companyservice.repos.customRepos.CompanyRepoCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Subgraph;
import java.util.List;
import java.util.Optional;

/**
 * This belongs to company-service
 *
 * @author Prabhu Madipalli
 */

@Repository
public class CompanyRepoCustomImpl implements CompanyRepoCustom {
    public CompanyRepoCustomImpl() {
        //Eg complete constructor
        this.egComplete = this.em.createEntityGraph(Company.class);
        this.egComplete.addAttributeNodes("id", "name", "turnover", "address", "furtherDetails");
        this.egComplete.addSubgraph("ceo").addAttributeNodes("id", "name");
        this.egComplete.addSubgraph("bod").addAttributeNodes("id", "name");
        Subgraph<StockCode> stockCodes = this.egComplete.addSubgraph("stockCodes");
        stockCodes.addAttributeNodes("id", "name");
        stockCodes.addSubgraph("stockExchange").addAttributeNodes("id", "name", "brief", "address", "remarks");
        this.egComplete.addSubgraph("sector").addAttributeNodes("id", "name", "brief");
        Subgraph<Object> ipos = this.egComplete.addSubgraph("ipos");
        ipos.addAttributeNodes("id", "code", "numberOfShares", "openDate");
        ipos.addSubgraph("stockExchange").addAttributeNodes("id", "name", "brief", "address", "remarks");

        //Eg basic construction
        this.egBasic = this.em.createEntityGraph(Company.class);
        this.egBasic.addAttributeNodes("id", "name", "turnover", "address", "furtherDetails");
        this.egBasic.addSubgraph("ceo").addAttributeNodes("id", "name");
        this.egBasic.addSubgraph("sector").addAttributeNodes("id", "name", "brief");

        //Eg Single COnstruction

        this.egSingle = em.createEntityGraph(Company.class);
        this.egSingle.addAttributeNodes("id", "name", "turnover", "address", "furtherDetails");

    }

    @PersistenceContext
    private EntityManager em;

    private final EntityGraph<Company> egBasic;

    private final EntityGraph<Company> egSingle;

    private final EntityGraph<Company> egComplete;

    @Override
    public List<Company> findCompaniesByNameContainingSingle(String partName){

        return this.em.createQuery("select c from company c where c.name like :partName", Company.class)
                .setParameter("partName", "%" + partName + "%")
                .setHint("javax.persistence.fetchgraph", this.egSingle)
                .getResultList();
    }

    @Override
    public Optional<Company> findByIdSingle(Integer id) {
        Company company = this.em.find(Company.class, id);
        return Optional.of(company);
    }

    @Override
    public List<Company> findAllSingle() {
        return this.em.createQuery("select c from company c")
                .setHint("javax.persistence.fetchgraph", this.egSingle)
                .getResultList();
    }

    @Override
    public Optional<Object> findCompanyByNameSingle(String name) {

        return Optional.of(
                this.em.createQuery("select c from company c where c.name like :name", Company.class)
                        .setParameter("name", name)
                        .setHint("javax.persistence.fetchgraph", this.egSingle)
                        .getSingleResult());

    }

    @Override
    public List<Company> findCompaniesByNameContainingComplete(String partName){

        return this.em.createQuery("select c from company c where c.name like :partName", Company.class)
                .setParameter("partName", "%" + partName + "%")
                .setHint("javax.persistence.fetchgraph", this.egComplete)
                .getResultList();
    }

    @Override
    public Optional<Company> findByIdComplete(Integer id) {
        Company company = this.em.find(Company.class, id);
        return Optional.of(company);
    }

    @Override
    public List<Company> findAllComplete() {
        return this.em.createQuery("select c from company c")
                .setHint("javax.persistence.fetchgraph", this.egComplete)
                .getResultList();
    }

    @Override
    public Optional<Object> findCompanyByNameComplete(String name) {

        return Optional.of(
                this.em.createQuery("select c from company c where c.name like :name", Company.class)
                        .setParameter("name", name)
                        .setHint("javax.persistence.fetchgraph", this.egComplete)
                        .getSingleResult());

    }

    @Override
    public List<Company> findCompaniesByNameContainingBasic(String partName){

        return this.em.createQuery("select c from company c where c.name like :partName", Company.class)
                .setParameter("partName", "%" + partName + "%")
                .setHint("javax.persistence.fetchgraph", this.egBasic)
                .getResultList();
    }

    @Override
    public Optional<Company> findByIdBasic(Integer id) {
        Company company = this.em.find(Company.class, id);
        return Optional.of(company);
    }

    @Override
    public List<Company> findAllBasic() {
        return this.em.createQuery("select c from company c")
                .setHint("javax.persistence.fetchgraph", this.egBasic)
                .getResultList();
    }

    @Override
    public Optional<Object> findCompanyByNameBasic(String name) {

        return Optional.of(
                this.em.createQuery("select c from company c where c.name like :name", Company.class)
                        .setParameter("name", name)
                        .setHint("javax.persistence.fetchgraph", this.egBasic)
                        .getSingleResult());

    }
}
