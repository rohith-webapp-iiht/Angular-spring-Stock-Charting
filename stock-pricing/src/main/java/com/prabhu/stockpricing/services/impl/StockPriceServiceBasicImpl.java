package com.prabhu.stockpricing.services.impl;

import com.prabhu.stockpricing.entities.StockPrice;
import com.prabhu.stockpricing.repos.StockPriceRepo;
import com.prabhu.stockpricing.services.interfaces.StockPriceServiceBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * This belongs to stock-pricing
 *
 * @author Prabhu Madipalli
 */

@Service
public class StockPriceServiceBasicImpl implements StockPriceServiceBasic {

    private final StockPriceRepo repo;

    @Autowired
    public StockPriceServiceBasicImpl(StockPriceRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<StockPrice> findAllByStockCodeId(int stockCodeId) {
        return repo.findAllByStockCodeId(stockCodeId);
    }

    @Override
    public Optional<StockPrice> findStockPriceByStockCodeIdAndDate(int stockCodeId, Date date) {
        return repo.findStockPriceByStockCodeIdAndDate(stockCodeId, date);
    }

    @Override
    public List<StockPrice> findAllByStockCodeIdAndDateAfterOrderByDate(int stockCodeId, Date date) {
        return repo.findAllByStockCodeIdAndDateAfterOrderByDate(stockCodeId, date);
    }

    @Override
    public List<StockPrice> findAllByStockCodeIdAndDateBetweenOrderByDate(int stockCodeId, Date startDate,
                                                                          Date endDate) {


        return repo.findAllByStockCodeIdAndDateBetweenOrderByDate(stockCodeId, startDate, endDate);
    }

    @Override
    public List<StockPrice> findAllByStockCodeIdAndDateBeforeOrderByDate(int stockCodeId, Date date) {
        return repo.findAllByStockCodeIdAndDateBeforeOrderByDate(stockCodeId, date);
    }

    @Override
    public List<StockPrice> findAllByStockCodeIdAndPriceLessThanEqualOrderByPriceDesc(int stockCodeId, long maxPrice) {
        return repo.findAllByStockCodeIdAndPriceLessThanEqualOrderByPriceDesc(stockCodeId, maxPrice);
    }

    @Override
    public List<StockPrice> findAllByStockCodeIdAndPriceGreaterThanEqualOrderByPriceAsc(int stockCodeId,
                                                                                           long minPrice) {

        return repo.findAllByStockCodeIdAndPriceGreaterThanEqualOrderByPriceAsc(stockCodeId, minPrice);
    }

    @Override
    public Optional<StockPrice> findStockPriceById(long id) {
        return repo.findById(id);
    }

    @Override
    public void save(Iterable<StockPrice> stockPrices) {
        repo.saveAll(stockPrices);
    }

    @Override
    public void save(StockPrice stockPrice) {
        repo.save(stockPrice);
    }
}
