package com.example.price.engine.dto;

import javax.validation.constraints.NotNull;

/**
 * @author Salaka, 5/26/2021 1:35 PM
 */
public class ProductRequestDto {

    private String name;
    private String remarks;
    @NotNull
    private Long pricePerCarton;
    @NotNull
    private Long unitPerCarton;

    public String getName() {
        return name;
    }

    public ProductRequestDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public ProductRequestDto setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public Long getPricePerCarton() {
        return pricePerCarton;
    }

    public ProductRequestDto setPricePerCarton(Long pricePerCarton) {
        this.pricePerCarton = pricePerCarton;
        return this;
    }

    public Long getUnitPerCarton() {
        return unitPerCarton;
    }

    public ProductRequestDto setUnitPerCarton(Long unitPerCarton) {
        this.unitPerCarton = unitPerCarton;
        return this;
    }
}
