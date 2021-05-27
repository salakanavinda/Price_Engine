package com.example.price.engine.service.impl;

import com.example.price.engine.entity.Stock;
import com.example.price.engine.repository.StockRepository;
import com.example.price.engine.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * CalculatorServiceImpl.
 *
 * @author Salaka, 5/26/2021 2:08 PM
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public double calculate(Long productId, boolean isCarton, long qty) {
        Optional<Stock> stock = stockRepository.findByProductId(productId);
        double price = 0.0;
        if (stock.isPresent()) {
            if (isCarton) {
                if (qty >= 3) {
                    double afterDiscountPrice = (double) stock.get()
                            .getProduct().getPricePerCarton() * 0.9;

                    price = (double) qty * afterDiscountPrice;
                } else {
                    price = (double) qty * (double) stock.get()
                            .getProduct().getPricePerCarton();
                }
            } else {
                double unitPrice = (double) stock.get()
                        .getProduct().getPricePerCarton() * 130 / (double) stock.get()
                        .getProduct().getUnitPerCarton();
                if (Double.isNaN(unitPrice) || Double.isInfinite(unitPrice)) {
                    price = 0.0;
                } else {
                    price = (double) qty * unitPrice;
                }
            }
        }
        return price;
    }
}
