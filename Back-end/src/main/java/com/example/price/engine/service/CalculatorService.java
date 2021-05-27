package com.example.price.engine.service;

/**
 * CalculatorService.
 *
 * @author Salaka, 5/26/2021 1:59 PM
 */
public interface CalculatorService {
    double calculate(Long productId,boolean isCarton , long qty);
}
