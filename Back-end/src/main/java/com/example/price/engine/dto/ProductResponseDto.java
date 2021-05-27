package com.example.price.engine.dto;

import com.example.price.engine.entity.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductResponseDto.
 *
 * @author Salaka, 5/26/2021 4:59 PM
 */
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductResponseDto {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public ProductResponseDto setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
