package com.example.price.engine.repository;

import com.example.price.engine.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * StockRepository.
 *
 * @author Salaka, 5/26/2021 1:03 PM
 */
public interface StockRepository extends JpaRepository<Stock,Long> {
    Optional<Stock> findByProductId(Long id);
}
