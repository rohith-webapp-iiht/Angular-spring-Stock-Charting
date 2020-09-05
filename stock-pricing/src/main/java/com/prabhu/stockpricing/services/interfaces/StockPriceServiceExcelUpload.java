package com.prabhu.stockpricing.services.interfaces;

import com.prabhu.stockpricing.entities.StockPrice;

import java.util.List;

/**
 * This belongs to stock-pricing
 *
 * @author Prabhu Madipalli
 */


public interface StockPriceServiceExcelUpload {

    List<StockPrice> process();

    boolean checkValid();

    boolean checkMissing();

    boolean checkFormat();

}
