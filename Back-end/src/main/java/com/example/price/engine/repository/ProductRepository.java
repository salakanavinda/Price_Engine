package com.example.price.engine.repository;

import com.example.price.engine.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository.
 *
 * @author Salaka, 5/26/2021 1:01 PM
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
