package com.example.price.engine.service.impl;

import com.example.price.engine.entity.Stock;
import com.example.price.engine.repository.StockRepository;
import com.example.price.engine.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * StockServiceImpl.
 *
 * @author Salaka, 5/26/2021 1:17 PM
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock getByProduct(Long id) {
        Optional<Stock> stock = stockRepository.findByProductId(id);
        if (stock.isPresent()) {
            return stock.get();
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public double calculatePrice(Long productId, boolean isCarton, long qty) {
        Optional<Stock> stock = stockRepository.findByProductId(productId);
        double price = 0.0;
        if (stock.isPresent()) {
            if (isCarton) {
                price = cartonWiseCalculation(stock.get(),qty);
            } else {
                if (qty < stock.get()
                        .getProduct().getUnitPerCarton()) {
                    price = singleUnitWiseCalculation(stock.get(),qty);
                } else {
                    price = cartonAndSingleUnitCalculation(stock.get(),qty);
                }
            }
        }
        if (price > 0.0) {
            price = Math.round(price * 100.0) / 100.0;
        }
        return price;
    }

    private double cartonWiseCalculation(Stock stock,long qty){
        if (qty >= 3 && stock
                .getProduct().getCartonWiseDiscount() > 0) {
            double percentage = 1.0 - stock
                    .getProduct().getCartonWiseDiscount() /100.0;
            double afterDiscountPrice = (double) stock
                    .getProduct().getPricePerCarton() * percentage;
            return  (double) qty * afterDiscountPrice;
        } else {
            return  (double) qty * (double) stock
                    .getProduct().getPricePerCarton();
        }
    }

    private double singleUnitWiseCalculation(Stock stock,long qty){
        double price;
        if (stock
                .getProduct().getSingleUnitCompensateValue() > 0) {
            double percentage = 1.0 + stock
                    .getProduct().getSingleUnitCompensateValue() /100.0;
            double unitPrice = (double) stock
                    .getProduct().getPricePerCarton() * percentage / (double) stock
                    .getProduct().getUnitPerCarton();

            if (Double.isNaN(unitPrice) || Double.isInfinite(unitPrice)) {
                price = 0.0;
            } else {
                price = (double) qty * unitPrice;
            }
        } else {
            double unitPrice = (double) stock
                    .getProduct().getPricePerCarton() / (double) stock
                    .getProduct().getUnitPerCarton();
            if (Double.isNaN(unitPrice) || Double.isInfinite(unitPrice)) {
                price = 0.0;
            } else {
                price = (double) qty * unitPrice;
            }
        }
        return price;
    }

    private double cartonAndSingleUnitCalculation(Stock stock,long qty) {
        long carton = qty / stock.getProduct().getUnitPerCarton();
        long extraUnit = qty - (carton * stock.getProduct().getUnitPerCarton());
        return cartonWiseCalculation(stock,carton) + singleUnitWiseCalculation(stock,extraUnit);
    }
}
