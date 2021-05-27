package com.example.price.engine.controller;

import com.example.price.engine.dto.ProductRequestDto;
import com.example.price.engine.dto.ProductResponseDto;
import com.example.price.engine.entity.Product;
import com.example.price.engine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static com.example.price.engine.config.Constants.ProductRequestMappings.*;
/**
 * PriceController
 *
 * @author Salaka, 5/25/2021 7:46 PM
 */
@RestController
@RequestMapping(PRODUCT_ROOT_PATH)
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseBody
    public Product create(@RequestBody @Valid ProductRequestDto request) {
        return productService.create(request);
    }

    @GetMapping(PRODUCT_BY_ID)
    @ResponseBody
    public Product get(@PathVariable(value = "id") Long id) {
       return productService.getById(id);
    }

    @GetMapping
    @ResponseBody
    public ProductResponseDto getAll() {
        return productService.getAll();
    }

}
