package com.example.price.engine.controller;

import com.example.price.engine.entity.Stock;
import com.example.price.engine.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

import static com.example.price.engine.config.Constants.StockRequestMappings.*;
/**
 * StockController.
 *
 * @author Salaka, 5/26/2021 1:16 PM
 */
@RestController
@RequestMapping(STOCK_ROOT_PATH)
@Validated
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(STOCK_BY_PRODUCT)
    @ResponseBody
    public Stock getByProduct(@PathVariable(value = "product_id") Long id) {
        return stockService.getByProduct(id);
    }

    @GetMapping(PRICE)
    public double getPrice(@RequestParam("product_id") long productId,
                           @RequestParam(value = "is_carton",required = false) boolean isCarton,
                           @RequestParam("qty")
                               @Positive(message = "qty cannot less than 1") long qty) {
        return stockService.calculatePrice(productId,isCarton,qty);
    }
}
