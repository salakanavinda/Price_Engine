package com.example.price.engine.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;

import java.io.Serializable;

import static com.example.price.engine.config.Constants.ProductConstants.*;

/**
 * Product.
 *
 * @author Salaka, 5/26/2021 9:10 AM
 */
@Entity
@Table(name = TABLE_NAME)
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product implements Serializable {

    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = REMARKS)
    private String remarks;

    @Column(name = PRICE_PER_CARTON,nullable = false)
    private long pricePerCarton;

    @Column(name = UNIT_PER_CARTON,nullable = false)
    private long unitPerCarton;

    @Column(name = CARTON_WISE_DISCOUNT)
    private double cartonWiseDiscount;

    @Column(name = SINGLE_UNIT_COMPENSATE_VALUE)
    private double singleUnitCompensateValue;

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public Product setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public long getPricePerCarton() {
        return pricePerCarton;
    }

    public Product setPricePerCarton(long pricePerCarton) {
        this.pricePerCarton = pricePerCarton;
        return this;
    }

    public long getUnitPerCarton() {
        return unitPerCarton;
    }

    public Product setUnitPerCarton(long unitPerCarton) {
        this.unitPerCarton = unitPerCarton;
        return this;
    }

    public double getCartonWiseDiscount() {
        return cartonWiseDiscount;
    }

    public Product setCartonWiseDiscount(double cartonWiseDiscount) {
        this.cartonWiseDiscount = cartonWiseDiscount;
        return this;
    }

    public double getSingleUnitCompensateValue() {
        return singleUnitCompensateValue;
    }

    public Product setSingleUnitCompensateValue(double singleUnitCompensateValue) {
        this.singleUnitCompensateValue = singleUnitCompensateValue;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remarks='" + remarks + '\'' +
                ", pricePerCarton=" + pricePerCarton +
                ", unitPerCarton=" + unitPerCarton +
                ", cartonWiseDiscount=" + cartonWiseDiscount +
                ", singleUnitCompensateValue=" + singleUnitCompensateValue +
                '}';
    }
}
