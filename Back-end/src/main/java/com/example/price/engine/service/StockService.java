package com.example.price.engine.service;

import com.example.price.engine.entity.Stock;

/**
 * @author Salaka, 5/26/2021 1:17 PM
 */
public interface StockService {
    Stock getByProduct(Long id);
    double calculatePrice(Long productId, boolean isCarton, long qty);

}
