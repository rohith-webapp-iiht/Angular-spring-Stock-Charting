package com.prabhu.stockpricing.services.impl;

import com.prabhu.stockpricing.entities.StockPrice;
import com.prabhu.stockpricing.repos.StockPriceRepo;
import com.prabhu.stockpricing.services.interfaces.StockPriceServiceExcelUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This belongs to stock-pricing
 *
 * @author Prabhu Madipalli
 */

@Service
public class StockPriceServiceExcelUploadImpl implements StockPriceServiceExcelUpload {

    private final StockPriceRepo repo;

    @Autowired
    public StockPriceServiceExcelUploadImpl(StockPriceRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<StockPrice> process() {
        return null;
    }

    @Override
    public boolean checkValid() {
        return false;
    }

    @Override
    public boolean checkMissing() {
        return false;
    }

    @Override
    public boolean checkFormat() {
        return false;
    }
}
