package com.example.price.engine.service.impl;

import com.example.price.engine.dto.ProductRequestDto;
import com.example.price.engine.dto.ProductResponseDto;
import com.example.price.engine.entity.Product;
import com.example.price.engine.repository.ProductRepository;
import com.example.price.engine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProductServiceImpl.
 *
 * @author Salaka, 5/26/2021 9:11 AM
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(ProductRequestDto request) {
        Product product = new Product()
                .setName(request.getName())
                .setRemarks(request.getRemarks())
                .setPricePerCarton(request.getPricePerCarton())
                .setUnitPerCarton(request.getUnitPerCarton());
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public ProductResponseDto getAll() {
        ProductResponseDto responseDto = new ProductResponseDto();
        List<Product> products = productRepository.findAll();
        if (!products.isEmpty()) {
            responseDto.setProducts(products);
        }
        return responseDto;
    }
}
