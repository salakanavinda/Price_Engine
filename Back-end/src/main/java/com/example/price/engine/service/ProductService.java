package com.example.price.engine.service;

import com.example.price.engine.dto.ProductRequestDto;
import com.example.price.engine.dto.ProductResponseDto;
import com.example.price.engine.entity.Product;

/**
 * ProductService.
 *
 * @author Salaka, 5/26/2021 9:11 AM
 */
public interface ProductService {

    Product create(ProductRequestDto request);
    Product getById(Long id);

    ProductResponseDto getAll();
}
